#define PIXEL_SIZE 5.0

void main() {
	vec2 uv = gl_FragCoord.xy / iResolution.xy;
    
    float plx = iResolution.x * PIXEL_SIZE / 500.0;
    float ply = iResolution.y * PIXEL_SIZE / 275.0;
    
    float dx = plx * (1.0 / iResolution.x);
    float dy = ply * (1.0 / iResolution.y);
    
    uv.x = dx * floor(uv.x / dx);
    uv.y = dy * floor(uv.y / dy);
    
    gl_FragColor = texture2D(iChannel0, uv);
}