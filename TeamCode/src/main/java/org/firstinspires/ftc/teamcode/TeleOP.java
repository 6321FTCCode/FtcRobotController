package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "main")
public class TeleOP extends OpMode {
    double ticks = 537.7;
    double newTarget;
    DcMotor motorFR;
    DcMotor motorFL;
    DcMotor motorBR;
    DcMotor motorBL;

    @Override
    public void init() {
        //code that runs once when INIT is pressed
        motorFR  = hardwareMap.get(DcMotor.class, "motor");
//        motorFL  = hardwareMap.get(DcMotor.class, "motorFL");
//        motorBR  = hardwareMap.get(DcMotor.class, "motorBR");
//        motorBL  = hardwareMap.get(DcMotor.class, "motorBL");
        telemetry.addData("Hardware: ", "Initialized");

        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        //code that runs repeat
        double speed = 0.5;
        float lStick = gamepad1.left_stick_y;
//        float lTrigger = gamepad1.left_trigger;
//        float rTrigger = gamepad1.right_trigger;
//        if (lStick<0){
//            motorFR.setPower(lStick);
//        } else if (lStick>0) {
//            motorFR.setPower(lStick);
//        } else {
//            motorFR.setPower(0);
//        }
        if (gamepad1.a) {
            encoder(2);
        }
    }

    public void encoder(int turnage) {
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        newTarget = ticks/turnage;
        motorFR.setTargetPosition((int)newTarget);
        motorFR.setPower(0.3);
        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}