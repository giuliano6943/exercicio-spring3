    package com.devsuperior.exercicio_spring3.dto;

    import com.devsuperior.exercicio_spring3.entities.Client;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.PastOrPresent;
    import jakarta.validation.constraints.PositiveOrZero;

    import java.time.LocalDate;

    public class ClientDTO {

        private Long id;
        @NotBlank(message = "O campo 'name' não pode estar vazio")
        private String name;
        private String cpf;
        @PositiveOrZero(message = "O salário não pode ser negativo")
        private Double income;
        @PastOrPresent(message = "Data de nascimento não pode ser futura")
        private LocalDate birthDate;
        @PositiveOrZero
        private Integer children;

        public ClientDTO() {
        }

        public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
            this.id = id;
            this.name = name;
            this.cpf = cpf;
            this.income = income;
            this.birthDate = birthDate;
            this.children = children;
        }

        public ClientDTO(Client entity){
            id = entity.getId();
            name = entity.getName();
            cpf = entity.getCpf();
            income = entity.getIncome();
            birthDate = entity.getBirthDate();
            children = entity.getChildren();
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCpf() {
            return cpf;
        }

        public Double getIncome() {
            return income;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public Integer getChildren() {
            return children;
        }
    }
