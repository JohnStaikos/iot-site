package com.project.iotsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={". "})
public class IoTSiteApplication {
/*
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private TypeRepository deviceTypeRepo;

    @Autowired
    private DeviceRepository deviceRepo;*/

    public static void main(String[] args) {
        SpringApplication.run(IoTSiteApplication.class, args);
    }

   /* @Bean
    ApplicationRunner init() {
        return args -> {
            Role admin = new Role("ADMIN");
            roleRepo.save(admin);

            Role userRole = new Role("USER");
            roleRepo.save(userRole);

            Random random = new Random(2);
            Stream.of("Yannis", "Dimitris", "Helen", "George").forEach(name -> {
                        User user = new User();
                        user.setName(name);
                        user.setSurname("Codingschool");
                        user.setPassword("****");
                        user.setEmail(name + "@gmai.com");
                        user.setRole(random.nextInt() < 2 ? admin : userRole);
                        userRepo.save(user);
                    }
            );

            userRepo.findAll().forEach(System.out::println);


            Room kitchen = new Room("Kitchen");
            Room diningRoom = new Room("Dining Room");


            Type coffeeMaker = new Type();
            coffeeMaker.setName("CoffeeMaker");

            Type television = new Type("Television");
            deviceTypeRepo.save(coffeeMaker);
            deviceTypeRepo.save(television);

            Device nespressoCoffeeMaker = new Device("Nespresso Inisia", "We like it", (short)0, coffeeMaker);
            deviceRepo.save(nespressoCoffeeMaker);

            kitchen.addDevice(nespressoCoffeeMaker);
            roomRepo.save(kitchen);

            roomRepo.save(diningRoom);

            *//*Optional<User> me = userRepo.findById(3L);
            if (me.isPresent()) {
              User yannis = me.get();
              yannis.addDevice(nespressoCoffeeMaker);
              userRepo.save(yannis);

            }*//*

            Device krups = new Device("Krups", "", (short)0, coffeeMaker);
            krups.setRoom(diningRoom);
            deviceRepo.save(krups);



        };*/
}
