package patterns.builder;

class Human {

    String name;
    String surname;
    int age;
    Human father;
    Human muther;

    Human(String name, String surname, int age, Human father, Human muther) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.father = father;
        this.muther = muther;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {

        private Builder() {}

        private String name;
        private String surname;
        private int age;
        private Human father;
        private Human muther;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setFather(Human father) {
            this.father = father;
            return this;
        }
        public Builder setMuther(Human muther) {
            this.muther = muther;
            return this;
        }

        public Human build() {
            return new Human(name, surname, age, father, muther);
        }
    }
}
