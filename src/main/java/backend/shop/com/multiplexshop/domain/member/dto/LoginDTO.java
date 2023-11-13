package backend.shop.com.multiplexshop.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginDTO {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String memberEmailId;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

}
