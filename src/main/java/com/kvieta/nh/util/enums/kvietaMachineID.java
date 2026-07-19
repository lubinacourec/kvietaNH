package com.kvieta.nh.util.enums;

public enum kvietaMachineID {

    // use range 24000-24999

    BRICK_PIPE(24000), // 24000-24004
    SOMETHING_ELSE(24005);

    public final int ID;

    kvietaMachineID(int ID) {
        this.ID = ID;
    }
}
