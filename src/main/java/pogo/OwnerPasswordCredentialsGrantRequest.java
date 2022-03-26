package pogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPasswordCredentialsGrantRequest {
	private String grant_type;
	private String username;
	private String password;
}
