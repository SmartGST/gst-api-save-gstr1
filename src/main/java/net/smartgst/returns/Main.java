package net.smartgst.returns;

import net.smartgst.auth.GSTAuth;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by gowthaman on 27/11/16.
 */
public class Main {
    public static final String BASE_URL = "http://devapi.gstsystem.co.in";
    public static final String AUTH_PATH = "/taxpayerapi/v0.1/authenticate";

    //random User Name
    private static final String USER_NAME = UUID.randomUUID().toString();
    //random Trx Id
    private static final String TXN = UUID.randomUUID().toString();

    //hard coded state code
    private static final String STATE_CD = "11";

    private static final String CLIENT_ID = "l7xx6df7496552824f15b7f4523c0a1fc114";
    private static final String CLIENT_SECRET = "f328fe52752349c893aa93adcffed8f5";


    //hard coded OTP
    private static final String OTP = "102030";

    //hard coded for now
    private static final String IP_USR = "192.168.1.1";


    public static void main(String[] args) throws Exception {
        InputStream pubKeyInpStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("GSTN_PublicKey.cer");


        GSTAuth gspAuth = new GSTAuth(
                CLIENT_ID, CLIENT_SECRET,
                USER_NAME, STATE_CD, IP_USR,
                TXN, pubKeyInpStream);

        if (gspAuth.otpRequest()) {
            System.out.println("OTP Request Success");
            if (gspAuth.authTokenRequest(OTP)) {
                System.out.println("Auth Token Success");

            }
        }

    }
}
