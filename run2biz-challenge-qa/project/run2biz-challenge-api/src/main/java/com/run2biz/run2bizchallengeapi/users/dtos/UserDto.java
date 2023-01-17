package com.run2biz.run2bizchallengeapi.users.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
public class UserDto {
    @JsonView(UserDtoView.Get.class)
    private Long id;

    @JsonView({UserDtoView.Create.class, UserDtoView.Get.class})
    @NotBlank(groups = UserDtoView.Create.class)
    @Pattern(regexp = "^[\\p{L} ]+$", groups = UserDtoView.Create.class, message = "must contain only letters")
    private String name;

    @JsonView({UserDtoView.Create.class, UserDtoView.Get.class})
    @NotBlank(groups = UserDtoView.Create.class)
    @CPF(groups = UserDtoView.Create.class)
    private String cpf;

    @JsonView({UserDtoView.Create.class, UserDtoView.Get.class})
    @NotBlank(groups = UserDtoView.Create.class)
    @Email(groups = UserDtoView.Create.class)
    private String email;

    @JsonView({UserDtoView.Create.class})
    @NotBlank(groups = UserDtoView.Create.class)
    @Min(8)
    private String password;
}
