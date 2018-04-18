package view.attribute;

import javafx.scene.control.DatePicker;
import view.attribute.base.BaseAttribute;

import java.time.LocalDate;

public class DatePickerAttribute extends BaseAttribute {

    public DatePickerAttribute(String name, boolean now) {
        super(name);

        value = new DatePicker();

        if(now)
            ((DatePicker)value).setValue(LocalDate.now());
    }

    @Override
    public LocalDate getValue() {
        return ((DatePicker)value).getValue();
    }
}
