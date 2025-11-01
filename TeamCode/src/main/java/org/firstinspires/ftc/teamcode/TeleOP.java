package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "main")
public class TeleOP extends OpMode {
//    double ticks = 537.7;
//    double newTarget;
    DcMotor motorFR;
    DcMotor motorFL;
    DcMotor motorBR;
    DcMotor motorBL;
    DcMotor spinner1;
    DcMotor conveyor;
    DcMotor launcherR;
    DcMotor launcherL;
    @Override
    public void init() {
        //code that runs once when INIT is pressed
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
        conveyor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launcherL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launcherR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);




        }

    @Override
    public void loop() {
        //code that runs repeat
        motorFL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);

        double speed = 1;
        double speed2 = 0.1;

        double axial = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double lateral = gamepad1.left_stick_x; // Counteract imperfect strafing
        double yaw = gamepad1.right_stick_x;


        double frontLeftPower = (axial - lateral + yaw);
        double backLeftPower = (axial + lateral + yaw);
        double frontRightPower = (axial - lateral - yaw);
        double backRightPower = (axial + lateral - yaw);

        motorFL.setPower(frontLeftPower);
        motorBL.setPower(backLeftPower);
        motorFR.setPower(frontRightPower);
        motorBR.setPower(backRightPower);

        telemetry.addData("axial: ",axial);
        telemetry.addData("lateral: ",lateral);
        telemetry.addData("yaw: ",yaw);
        telemetry.addData("FL pwr: ",frontLeftPower);
        telemetry.addData("BL pwr: ",backLeftPower);
        telemetry.addData("FR pwr: ",frontRightPower);
        telemetry.addData("BR pwr: ",backRightPower);

        if (gamepad2.right_trigger>0){
            spinner1.setPower(0.8);
        } else {
            spinner1.setPower(0);
        }

        if (gamepad2.y){
            conveyor.setPower(1);
            launcherR.setPower(-1); //counterclockwise
            launcherL.setPower(1); //clockwise
        } else {
            conveyor.setPower(0);
            launcherR.setPower(0);
            launcherL.setPower(0);
        }

//        if (gamepad2.left_stick_y<0){
//            //forwards when gamepad is pushed upwards
//            motorFR.setPower(speed2);
//            motorFL.setPower(-speed2);
//            motorBL.setPower(-speed2);
//            motorBR.setPower(speed2);
//        } else if (gamepad2.left_stick_y>0) {
//            //backwards when gamepad is pushed downwards
//            motorFR.setPower(-speed2);
//            motorFL.setPower(speed2);
//            motorBL.setPower(speed2);
//            motorBR.setPower(-speed2);
//        } else if (gamepad2.left_stick_x<0){
//            //strafes left when left stick pushed to the left
//            motorFR.setPower(speed2);
//            motorFL.setPower(speed2);
//            motorBL.setPower(-speed2);
//            motorBR.setPower(-speed2);
//        } else if (gamepad2.left_stick_x>0) {
//            //strafes right when
//            motorFR.setPower(-speed2);
//            motorFL.setPower(-speed2);
//            motorBL.setPower(speed2);
//            motorBR.setPower(speed2);
//        }
//
//        if (gamepad2.right_stick_x<0){
//            //rotate left
//            motorFR.setPower(speed2);
//            motorFL.setPower(speed2);
//            motorBL.setPower(speed2);
//            motorBR.setPower(speed2);
//        } else if (gamepad2.right_stick_x>0){
//            motorFR.setPower(-speed2);
//            motorFL.setPower(-speed2);
//            motorBL.setPower(-speed2);
//            motorBR.setPower(-speed2);
//        } else {
//            motorFR.setPower(0);
//            motorFL.setPower(0);
//            motorBL.setPower(0);
//            motorBR.setPower(0);
//        }

//        if (gamepad1.y) {
//            speed = 1;
//        }


    }
}

//    public void encoder(int turnage) {
//        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        newTarget = ticks/turnage;
//        motorFR.setTargetPosition((int)newTarget);
//        motorFR.setPower(0.3);
//        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

