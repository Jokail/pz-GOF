package creational.builder;

public class BuilderDemo {

    public static void run() {

        Computer gamingPc = new Computer.Builder("Intel i9-14900K", "64GB DDR5")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .os("Windows 11 Pro")
                .build();

        Computer officePc = new Computer.Builder("Intel i5-13400", "16GB DDR4")
                .storage("512GB SSD")
                .os("Ubuntu 24.04")
                .build();

        Computer serverNode = new Computer.Builder("AMD EPYC 9654", "512GB DDR5")
                .storage("8TB NVMe RAID")
                .build();
        Computer server = new Computer.Builder("123", "512GB DDR5").build();

        System.out.println("[Builder] Ігровий ПК:  " + gamingPc);
        System.out.println("[Builder] Офісний ПК:  " + officePc);
        System.out.println("[Builder] Серверний вузол: " + serverNode);
        System.out.println(server);
        System.out.println();
    }
}
