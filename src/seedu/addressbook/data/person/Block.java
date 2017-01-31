package seedu.addressbook.data.person;

public class Block {
    private String _value;
    
    public Block(String block) {
        this._value = block;
    }

    private String get_value() {
        return _value;
    }

    private void set_value(String _value) {
        this._value = _value;
    }
}
