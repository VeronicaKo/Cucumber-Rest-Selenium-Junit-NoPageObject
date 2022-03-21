package pogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorisationResponse{
	private String access_token;
	private String refresh_token;
	private String token_type;
	private int expires_in;
}