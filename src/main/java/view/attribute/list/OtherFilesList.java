package view.attribute.list;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.attribute.special.OtherFileAttribute;

import java.util.ArrayList;
import java.util.List;

public class OtherFilesList extends GridPane {

    private List<OtherFileAttribute> otherFileAttributes;
    private Button addNewBtn;

    private final int MAX = 3;

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

    private void removeItem(int id) {
        for (int i = 0; i < otherFileAttributes.size(); i++) {
            if (id == otherFileAttributes.get(i).getUniqueId())
                otherFileAttributes.remove(i);
        }

        getChildren().clear();

        load();
    }

    private void load() {
        // Static
        add(new Label("Other File"), 0, 0);
        add(addNewBtn, 1, 0);

        // Dynamic
        for (int i = 0; i < otherFileAttributes.size(); i++)
            add(otherFileAttributes.get(i), 0, i+2, 3, 1);

    }

    public List<OtherFileAttribute> getOtherFileAttributes() {
        return otherFileAttributes;
    }
}
