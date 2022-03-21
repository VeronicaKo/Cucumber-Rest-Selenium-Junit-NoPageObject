package pogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewPlayerRequest {
	private String surname;
	private String name;
	private String password_change;
	private String password_repeat;
	private String email;
	private String currency_code;
	private String username;
}