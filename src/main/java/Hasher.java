import org.apache.commons.codec.digest.Crypt;
import java.io.*;

public class Hasher {

    public void findPassword(){
        boolean cont = true;
        String currentPassword;
        String hashedPassword;

        try {

            File file = new File("src/main/resources/passwords.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while (((currentPassword = reader.readLine()) != null)&&(cont)) {
                hashedPassword = this.generateHash(currentPassword);
                if (Constants.PASSWORD.equals(hashedPassword)) {
                    System.out.println("Found! The password was: " + currentPassword);
                    cont = false;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private String generateHash(String password) {
        return Crypt.crypt(password, Constants.SALT);
    }

}