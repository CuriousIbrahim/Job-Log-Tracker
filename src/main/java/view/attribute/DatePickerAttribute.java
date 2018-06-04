package view.attribute;

import javafx.scene.control.DatePicker;
import view.attribute.base.BaseAttribute;

import java.time.LocalDate;

/**
 * An attribute that allows functionality to select dates and view them via DatePicker
 */

public class DatePickerAttribute extends BaseAttribute {

    /**
     * Constructs a DatePickerAttribute object, sets attribute label name and allows to set date to now by default
     * @param name Label name of attribute
     * @param now If true, will set date to now, if false, untested behaviour
     */

    public DatePickerAttribute(String name, boolean now) {
        super(name);

        value = new DatePicker();

        if(now)
            ((DatePicker)value).setValue(LocalDate.now());

        addValueNodeToPane();
    }

    /**
     * Returns attribute's value, the date
     * @return Attribute's value, the date
     */

    @Override
    public LocalDate getValue() {
        return ((DatePicker)value).getValue();
    }

    /**
     * Sets the value of the attribute
     * @param o Value to place in view
     */

    @Override
    public void setValue(Object o) {

        LocalDate temp = null;

        if (o instanceof LocalDate)
            temp = (LocalDate) o;
        else
            return;

        ((DatePicker)value).setValue(temp);

    }
}
