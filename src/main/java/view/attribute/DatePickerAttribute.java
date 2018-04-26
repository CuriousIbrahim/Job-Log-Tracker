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

        addValueNodeToPane();
    }

    @Override
    public LocalDate getValue() {
        return ((DatePicker)value).getValue();
    }

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
