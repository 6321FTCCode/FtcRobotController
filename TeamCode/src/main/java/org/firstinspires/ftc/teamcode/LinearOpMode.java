//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//@Autonomous
//public class LinearOpMode extends LinearOpMode {
//
//    private DcMotor leftMotor;
//    private DcMotor rightMotor;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        // Initialize hardware
//        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
//        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // Move forward at half power for 2 seconds
//        leftMotor.setPower(0.5);
//        rightMotor.setPower(0.5);
//        sleep(2000);
//
//        // Stop motors
//        leftMotor.setPower(0);
//        rightMotor.setPower(0);
//    }
//}