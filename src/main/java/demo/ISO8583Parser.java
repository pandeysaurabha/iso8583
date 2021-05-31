package demo;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class ISO8583Parser {
    public static void main(String[] args) throws ISOException {

        GenericPackager genericPackager = new GenericPackager(Constants.ISO_1987_ASCII);
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(genericPackager);

        byte[] byteIsoMessage = new byte[Constants.iso8583Message.length()];
        for (int i = 0; i < byteIsoMessage.length; i++) {
            byteIsoMessage[i] = (byte) (int) Constants.iso8583Message.charAt(i);
        }
        isoMsg.unpack(byteIsoMessage);

        System.out.println("MTI:'" + isoMsg.getMTI() + "'");
        for (int i = 1; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i))
                System.out.println(i + "='" + isoMsg.getString(i) + "'");
        }
    }
}