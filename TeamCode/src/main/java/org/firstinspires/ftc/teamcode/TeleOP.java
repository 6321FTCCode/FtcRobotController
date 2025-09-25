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

    @Override
    public void init() {
        //code that runs once when INIT is pressed
        motorFR  = hardwareMap.get(DcMotor.class, "motor");
        motorFL  = hardwareMap.get(DcMotor.class, "motorFL");
        motorBR  = hardwareMap.get(DcMotor.class, "motorBR");
        motorBL  = hardwareMap.get(DcMotor.class, "motorBL");
        telemetry.addData("Hardware: ", "Initialized");

        //motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        //code that runs repeat
        double speed = 0.5;

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
        } else {
            //sets power to 0 when nothing happens to the left stick
            motorFR.setPower(0);
            motorFL.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);
        }

        if (gamepad1.left_stick_x<0){
            //strafes left when left stick pushed to the left
            motorFR.setPower(-speed);
            motorFL.setPower(-speed);
            motorBL.setPower(speed);
            motorBR.setPower(speed);
        } else if (gamepad1.left_stick_x>0) {
            //strafes right when 
            motorFR.setPower(speed);
            motorFL.setPower(speed);
            motorBL.setPower(-speed);
            motorBR.setPower(-speed);
        } else {
            motorFR.setPower(0);
            motorFL.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);
        }

        if (gamepad1.right_stick_x<0){
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
        if (gamepad1.a) {
            speed = 1;
        }
    }

//    public void encoder(int turnage) {
//        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        newTarget = ticks/turnage;
//        motorFR.setTargetPosition((int)newTarget);
//        motorFR.setPower(0.3);
//        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

}