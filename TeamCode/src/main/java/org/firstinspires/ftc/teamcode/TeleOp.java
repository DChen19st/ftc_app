package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jen on 11/9/2016.
 */
@TeleOp(name = "TeleOp", group = "Tutorials")

public class TeleOp extends LinearOpMode {
        private DcMotor motorLeft;
        private DcMotor motorRight;

        private Servo armServo;

        private static final double Arm_Retracted_Position = 0.2;
        private static final double Arm_Extended_Position = 0.8;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get("armServo");

        armServo.setPosition(Arm_Retracted_Position);
        armServo.setPosition(Arm_Extended_Position);

        waitForStart();

        while (opModeIsActive()) {
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            if (gamepad2.a)
            {
                armServo.setPosition(Arm_Extended_Position);
            }
            if (gamepad2.b)
            {
                armServo.setPosition(Arm_Retracted_Position);
            }


            idle();
        }
    }
}


