package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

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

    @Override
    public void init() {
        //code that runs once when INIT is pressed
        motorFR  = hardwareMap.get(DcMotor.class, "front_right_motor");
        motorFL  = hardwareMap.get(DcMotor.class, "front_left_motor");
        motorBR  = hardwareMap.get(DcMotor.class, "back_right_motor");
        motorBL  = hardwareMap.get(DcMotor.class, "back_left_motor");
        spinner1 = hardwareMap.get(DcMotor.class, "spinner1");
        conveyor = hardwareMap.get(DcMotor.class, "conveyer");
        telemetry.addData("Hardware: ", "Initialized");

        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinner1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        conveyor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        //code that runs repeat
        double speed = 1;

//        float lTrigger = gamepad1.left_trigger;
//        float rTrigger = gamepad1.right_trigger;
        if (gamepad1.left_stick_y<0){
            //forwards when gamepad is pushed upwards
            motorFR.setPower(speed);
            motorFL.setPower(-speed);
            motorBL.setPower(-speed);
            motorBR.setPower(speed);
        } else if (gamepad1.left_stick_y>0) {
            //backwards when gamepad is pushed downwards
            motorFR.setPower(-speed);
            motorFL.setPower(speed);
            motorBL.setPower(speed);
            motorBR.setPower(-speed);
        } else if (gamepad1.left_stick_x<0){
            //strafes left when left stick pushed to the left
            motorFR.setPower(speed);
            motorFL.setPower(-speed);
            motorBL.setPower(speed);
            motorBR.setPower(-speed);
        } else if (gamepad1.left_stick_x>0) {
            //strafes right when 
            motorFR.setPower(-speed);
            motorFL.setPower(speed);
            motorBL.setPower(-speed);
            motorBR.setPower(speed);
        } else {
            motorFR.setPower(0);
            motorFL.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);
        }

        if (gamepad1.right_stick_x<0){
            //rotate left
            motorFR.setPower(speed);
            motorFL.setPower(speed);
            motorBL.setPower(speed);
            motorBR.setPower(speed);
        } else if (gamepad1.right_stick_x>0){
            motorFR.setPower(-speed);
            motorFL.setPower(-speed);
            motorBL.setPower(-speed);
            motorBR.setPower(-speed);
        } else {
            motorFR.setPower(0);
            motorFL.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);
        }

        if (gamepad1.right_trigger>0){
            spinner1.setPower(0.8);
        } else {
            spinner1.setPower(0);
        }

        if (gamepad1.y){
            conveyor.setPower(1);
        } else {
            conveyor.setPower(0);
        }
//        if (gamepad1.y) {
//            speed = 1;
//        }


    }

//    public void encoder(int turnage) {
//        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        newTarget = ticks/turnage;
//        motorFR.setTargetPosition((int)newTarget);
//        motorFR.setPower(0.3);
//        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

}