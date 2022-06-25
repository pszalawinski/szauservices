import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

import com.nimbusds.jose.JOSEException;

@SpringBootApplication
public class JweEncryptDecryptAppBlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(JweEncryptDecryptAppBlogApplication.class, args);

    try {
      com.cmbk.jwe.manager.service.EncrypyDecryptJweToken.encryptedJsonWebToken();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (InvalidKeySpecException e) {
      e.printStackTrace();
    } catch (JOSEException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
