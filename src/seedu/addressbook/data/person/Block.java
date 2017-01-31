package seedu.addressbook.data.person;

public class Block {
    private String _value;
    
    public Block(String block) {
        this._value = block;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }
}
