package k.core.util.netty;

public class TestPacket extends Packet implements ISendPacket, IReceivePacket {

    public TestPacket(String msg) {
        this(new DataStruct(new Object[] { msg }));
    }

    public TestPacket(DataStruct dataStruct) {
        super(dataStruct);
    }

    @Override
    public ISendPacket receive(NetHandler n) {
        System.err.println("Recived packet data " + data.get(0));
        return new TestPacket((String) data.get(0));
    }

    @Override
    public boolean send(NetHandler n) {
        System.err.println("Sent packet data " + data.get(0));
        return n.sendPacket(this);
    }

}