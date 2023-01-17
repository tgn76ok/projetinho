export type Error = {
  fieldName: string;
  message: string;
};

export function showError(errors: Error[]) {
  errors.map((error: Error) => {
    if (error.fieldName.includes('email')) {
      alert('Erro!\nEsse e-mail já foi cadastrado por outro usuário!');
    }
    if (error.fieldName.includes('cpf')) {
      alert(`Erro!\nNúmero de CPF inválido!`);
    }
  });
}
