package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="improvedRedBack")
public class redBackAutoImproved extends OpMode{
    DcMotor motorFR;
    DcMotor motorFL;
    DcMotor motorBR;
    DcMotor motorBL;
    DcMotor spinner1;
    DcMotor conveyor;
    DcMotor launcherR;
    DcMotor launcherL;
    Servo rampServo;

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
        rampServo = hardwareMap.get(Servo.class, "rampServo");

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
}
