
__kernel void rgbReplaceBlackAndWhite(
       DTYPE_IMAGE_IN_3D src,
       DTYPE_IMAGE_OUT_3D dst
)
{
    const sampler_t sampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_NEAREST;

    int4 posR = {get_global_id(0), get_global_id(1), 0, 0};
    int4 posG = {get_global_id(0), get_global_id(1), 1, 0};
    int4 posB = {get_global_id(0), get_global_id(1), 2, 0};

    float r = READ_IMAGE_3D(src, sampler, posR).x;
    float g = READ_IMAGE_3D(src, sampler, posG).x;
    float b = READ_IMAGE_3D(src, sampler, posB).x;

	if (!(fabs(r - g) > 0 || fabs(r - b) > 0 || fabs(b - g) > 0)) {
		// invert
		r = 255 - r;
		g = 255 - g;
		b = 255 - b;
	}

	WRITE_IMAGE_3D(dst, posR, CONVERT_DTYPE_OUT(r));
	WRITE_IMAGE_3D(dst, posG, CONVERT_DTYPE_OUT(g));
	WRITE_IMAGE_3D(dst, posB, CONVERT_DTYPE_OUT(b));
}
