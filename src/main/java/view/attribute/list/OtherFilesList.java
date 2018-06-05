package view.attribute.list;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.attribute.special.OtherFileAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Visual list (using GridPane) of OtherFileAttribute objects, allows the addition of new OtherFileAttributes (max of 3)
 * and removal of OtherFileAttributes
 */

public class OtherFilesList extends GridPane {

    private List<OtherFileAttribute> otherFileAttributes;
    private Button addNewBtn;

    private final int MAX = 3;

    /**
     * Constructs a OtherFilesList object, takes care of the placement of each visual object as well as its spacing
     */

    public OtherFilesList () {
        otherFileAttributes = new ArrayList<>();

        addNewBtn = new Button("Add New");

        addNewBtn.setOnAction(event -> {
            addItem();
        });

        load();

        setHgap(10);
        setVgap(10);

    }

    /**
     * Add a new OtherFileAttribute to the list with the given parameters filled in to its fields
     * @param name Name of file
     * @param filePath Path of file
     */

    public void addItem(String name, String filePath) {

        if (otherFileAttributes.size() >= MAX) {
            return;
        }

        getChildren().clear();

        OtherFileAttribute temp = new OtherFileAttribute(name, filePath);
        temp.getXButton().setOnAction(event -> {
            removeItem(temp.getUniqueId());
        });

        otherFileAttributes.add(0, temp);

        load();

    }

    /**
     * Add new OtherFileAttribute to list with empty fields
     */

    public void addItem() {

        if (otherFileAttributes.size() >= MAX) {
            return;
        }

        getChildren().clear();

        OtherFileAttribute temp = new OtherFileAttribute();
        temp.getXButton().setOnAction(event -> {
            removeItem(temp.getUniqueId());
        });

        otherFileAttributes.add(0, temp);

        load();

    }

    /**
     * Remove OtherFileAttribute from the List based on id
     * @param id Id of OtherFileAttribute to remove
     */

    private void removeItem(int id) {
        for (int i = 0; i < otherFileAttributes.size(); i++) {
            if (id == otherFileAttributes.get(i).getUniqueId())
                otherFileAttributes.remove(i);
        }

        getChildren().clear();

        load();
    }

    /**
     * Load/Reload view
     */

    private void load() {
        // Static
        add(new Label("Other File"), 0, 0);
        add(addNewBtn, 1, 0);

        // Dynamic
        for (int i = 0; i < otherFileAttributes.size(); i++)
            add(otherFileAttributes.get(i), 0, i+2, 3, 1);

    }

    /**
     * Return all the OtherFileAttribute in a List
     * @return All the OtherFileAttribute in a List
     */

    public List<OtherFileAttribute> getOtherFileAttributes() {
        return otherFileAttributes;
    }
}
