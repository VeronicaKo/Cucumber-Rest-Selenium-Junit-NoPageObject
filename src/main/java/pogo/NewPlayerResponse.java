package pogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewPlayerResponse {
    private boolean bonuses_allowed;
    private Object birthdate;
    private Object gender;
    private String surname;
    private Object timezone_id;
    private String name;
    private Object phone_number;
    private int id;
    private boolean is_verified;
    private Object country_id;
    private String email;
    private String username;
}