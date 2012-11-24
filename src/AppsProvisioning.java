/* INSTRUCTION: This is a command line application. So please execute this template with the following arguments:

 arg[0] = admin-username@domain (E.g. liz@abcd.com)
 arg[1] = admin-password
 arg[2] = domain (E.g. abcd.com)

 See more examples here: https://code.google.com/p/gdata-java-client/source/browse/trunk/java/sample/appsforyourdomain/AppsForYourDomainClient.java

 */

/**
 * @author (Your Name Here)
 *
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gdata.client.appsforyourdomain.UserService;
import com.google.gdata.data.appsforyourdomain.provisioning.UserEntry;
import com.google.gdata.data.appsforyourdomain.provisioning.UserFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

/**
 * This is a test template
 */

public class AppsProvisioning {

	public static void main(String[] args) {

		try {

			// Create a new Apps Provisioning service
			UserService myService = new UserService("My Application");
			myService.setUserCredentials(args[0], args[1]);

			// Get a list of all entries
			URL metafeedUrl = new URL("https://www.google.com/a/feeds/" + args[2]
							+ "/user/2.0/");
			System.out.println("Getting user entries...\n");
			UserFeed resultFeed = myService.getFeed(metafeedUrl, UserFeed.class);
			List<UserEntry> entries = resultFeed.getEntries();
			for (int i = 0; i < entries.size(); i++) {
				UserEntry entry = entries.get(i);
				System.out.println("\t" + entry.getTitle().getPlainText());
			}
			System.out.println("\nTotal Entries: " + entries.size());
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
