-ทดสอสอบ spring data jdbc
-mariadb

---แนวทางปฏิบัติการว่างโครงสร้างโปรเจ็ค --- 
com.example.app
├── controller/       (รับ Request/Response จากภายนอก)
├── service/          (เขียน Business Logic ล้วนๆ)
├── repository/       (คุยกับ Database)
├── model/            (คลาสหลักของระบบ / Entity ที่ผูกกับตาราง)
├── dto/              (POJO ธรรมดา เอาไว้รับส่งข้อมูลกับหน้าเว็บเท่านั้น)
├── config/           (พวกไฟล์ตั้งค่าต่างๆ)
└── exception/        (ดักจับและจัดการ Error)
