package from_jet_brains_academy.encrypted_decrypted_project;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EncryptDecryptTest {

    EncryptDecrypt encryptDecrypt = new EncryptDecrypt();

    @Test
    public void test() throws IOException {
        String[] args = {
                "-alg", "unicode",
                "-mode", "enc",
                "-key", "5",
                "-data", "Test is a test"};
        EncryptDecrypt.main(args);
    }
}