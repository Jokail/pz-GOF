package creational.builder;

public class Computer {

    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final String os;

    private Computer(Builder builder) {
        this.cpu     = builder.cpu;
        this.ram     = builder.ram;
        this.storage = builder.storage;
        this.gpu     = builder.gpu;
        this.os      = builder.os;
    }

    public String getCpu()     { return cpu; }
    public String getRam()     { return ram; }
    public String getStorage() { return storage; }
    public String getGpu()     { return gpu; }
    public String getOs()      { return os; }

    @Override
    public String toString() {
        return String.format(
            "Computer { CPU='%s', RAM='%s', Storage='%s', GPU='%s', OS='%s' }",
            cpu, ram, storage, gpu, os
        );
    }

    public static class Builder {

        private final String cpu;
        private final String ram;

        private String storage = "256GB SSD";
        private String gpu     = "Integrated";
        private String os      = "No OS";

        public Builder(String cpu, String ram) {
            if (cpu == null || cpu.isBlank()) throw new IllegalArgumentException("CPU is required");
            if (ram == null || ram.isBlank()) throw new IllegalArgumentException("RAM is required");
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
