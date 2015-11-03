/**
 * Created by ValV on 11/3/15.
 */
public class QConverter {
    // Fields
    protected final int XBIT = 1000; // Multiplicity for e.g. KBit
    protected final int XBYTE = 1024; // Multiplicity for e.g. KByte
    private long value; // Stored in bits

    // Methods
    public QConverter() {
        this.value = 0;
    }
    public QConverter(int value) {
        this.value = value;
    }

    public void fromBit(int aBit) {
        this.value = aBit;
    }

    public void fromKBit(int kBit) {
        this.value = kBit * XBIT;
    }

    public void fromMBit(int mBit) {
        this.value = mBit * XBIT * XBIT;
    }

    public void fromByte(int aByte) {
        this.value = aByte * 8;
    }

    public void fromKByte(int kByte) {
        this.value = kByte * 8 * XBYTE;
    }

    public double toBit() {
        return (double) this.value;
    }

    public double toKBit() {
        return ((double) this.value) / XBIT;
    }

    public double toMBit() {
        return ((double) this.value) / XBIT / XBIT;
    }

    public double toByte() {
        return ((double) this.value) / 8;
    }

    public double toKByte() {
        return ((double) this.value) / 8 / XBYTE;
    }
}
