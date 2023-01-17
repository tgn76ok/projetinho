function formatCpf(event: Event) {
  let value = (event.target as HTMLInputElement).value;
  value = value.replace(/\D/g, '');
  value = value.replace(/(\d{3})(\d)/, '$1.$2');
  value = value.replace(/(\d{3})(\d)/, '$1.$2');
  value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
  (event.target as HTMLInputElement).value = value;
}

export { formatCpf }
