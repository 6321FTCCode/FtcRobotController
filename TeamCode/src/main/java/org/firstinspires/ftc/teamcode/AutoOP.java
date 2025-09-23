package org.firstinspires.ftc.teamcode;

import static java.lang.Math.sin;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "auto")
public class AutoOP extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.get(DcMotor.class,"motorleft");

        waitForStart();
        while (opModeIsActive()) {
            leftMotor.setPower(0.7);
            Thread.sleep(2000);
            leftMotor.setPower(1);
            Thread.sleep(5000);
            leftMotor.setPower(0);
        }
    }
}