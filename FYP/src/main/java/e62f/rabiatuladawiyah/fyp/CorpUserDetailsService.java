/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-06 3:54:34 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 20021900
 *
 */
public class CorpUserDetailsService implements UserDetailsService {
	@Autowired
	private CorpUserRepository corpuserRepository;
	
	@Override
	public CorpUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CorpUser user= corpuserRepository.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new CorpUserDetails(user);
		}
	


}


