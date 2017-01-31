package seedu.addressbook.data.person;

public class Unit {
    private String _value;
    
    public Unit(String block) {
        this._value = block;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }
}
