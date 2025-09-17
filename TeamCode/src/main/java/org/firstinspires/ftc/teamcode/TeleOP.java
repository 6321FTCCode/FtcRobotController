package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "main")
public class TeleOP extends OpMode {

    DcMotor motor;

    @Override
    public void init() {
        //code that runs once when INIT is pressed
        motor  = hardwareMap.get(DcMotor.class, "motor");
        telemetry.addData("Hardware: ", "Initialized");
    }

    @Override
    public void loop() {
        //code that runs repeat

        if (gamepad1.a){
            telemetry.addData("A button Pressed",gamepad1.a);
            telemetry.update();
            motor.setPower(0.5);
        }
    }

}