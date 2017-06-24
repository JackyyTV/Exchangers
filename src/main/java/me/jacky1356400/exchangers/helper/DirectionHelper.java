package me.jacky1356400.exchangers.helper;

import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class DirectionHelper {

    /*** Facings for the 4 faces around X Axis */
    private static EnumFacing[] FACES_AROUND_X = new EnumFacing[1];
    /*** Facings for the 4 faces around Y Axis */
    private static EnumFacing[] FACES_AROUND_Y = new EnumFacing[1];
    /*** Facings for the 4 faces around Z Axis */
    private static EnumFacing[] FACES_AROUND_Z = new EnumFacing[1];

    public static void initFacings() {
        List<EnumFacing> x = new ArrayList<EnumFacing>();
        List<EnumFacing> y = new ArrayList<EnumFacing>();
        List<EnumFacing> z = new ArrayList<EnumFacing>();

        for (EnumFacing facing : EnumFacing.VALUES){
            if (facing.getAxis() != EnumFacing.Axis.X){
                x.add(facing);
            }
            if (facing.getAxis() != EnumFacing.Axis.Y){
                y.add(facing);
            }
            if (facing.getAxis() != EnumFacing.Axis.Z){
                z.add(facing);
            }
        }

        FACES_AROUND_X = x.toArray(new EnumFacing[1]);
        FACES_AROUND_Y = y.toArray(new EnumFacing[1]);
        FACES_AROUND_Z = z.toArray(new EnumFacing[1]);
    }

    public static EnumFacing[] getFacings(EnumFacing side) {
        EnumFacing[] facesAround = new EnumFacing[1];

        if (side.getAxis() == EnumFacing.Axis.X) {
            facesAround = FACES_AROUND_X;
        } else if (side.getAxis() == EnumFacing.Axis.Y) {
            facesAround = FACES_AROUND_Y;
        } else {
            facesAround = FACES_AROUND_Z;
        }

        return facesAround;
    }

}
