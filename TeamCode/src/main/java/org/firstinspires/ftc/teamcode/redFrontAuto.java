package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name = "RedFront")
public class redFrontAuto extends LinearOpMode {

    DcMotor motorFR;
    DcMotor motorFL;
    DcMotor motorBR;
    DcMotor motorBL;
    DcMotor spinner1;
    DcMotor conveyor;
    DcMotor launcherL;
    DcMotor launcherR;

    @Override
    public void runOpMode() throws InterruptedException {
        motorFR  = hardwareMap.get(DcMotor.class, "front_right_motor");
        motorFL  = hardwareMap.get(DcMotor.class, "front_left_motor");
        motorBR  = hardwareMap.get(DcMotor.class, "back_right_motor");
        motorBL  = hardwareMap.get(DcMotor.class, "back_left_motor");
        spinner1 = hardwareMap.get(DcMotor.class, "spinner1");
        conveyor = hardwareMap.get(DcMotor.class, "conveyor");
        launcherL = hardwareMap.get(DcMotor.class, "launcher_left");
        launcherR = hardwareMap.get(DcMotor.class, "launcher_right");
        telemetry.addData("Hardware: ", "Initialized");

        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinner1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        motorFR.setPower(0.5);
        motorFL.setPower(-0.5);
        motorBL.setPower(-0.5);
        motorBR.setPower(0.5);
        Thread.sleep(2500);
        motorFR.setPower(0);
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
        launcherL.setPower(0.90);
        launcherR.setPower(0.90);
        Thread.sleep(1000);
        spinner1.setPower(-1);
        conveyor.setPower(0.5);
        Thread.sleep(100);
        for (int i=0;i<6;i++){
            conveyor.setPower(0);
            Thread.sleep(400);
            conveyor.setPower(0.5);
            Thread.sleep(400);
        }
        launcherR.setPower(0);
        launcherL.setPower(0);
        spinner1.setPower(0);
        conveyor.setPower(0);
        motorFR.setPower(1);
        motorFL.setPower(1);
        motorBL.setPower(-1);
        motorBR.setPower(-1);
        Thread.sleep(750);
        motorFR.setPower(0);
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);





//        while (opModeIsActive()) {
//            leftMotor.setPower(0.7);
//            Thread.sleep(2000);
//            leftMotor.setPower(1);
//            Thread.sleep(5000);
//            leftMotor.setPower(0);
//        }
    }
}