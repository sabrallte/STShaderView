uniform vec3      iResolution;           // viewport resolution (in pixels)
uniform float     iGlobalTime;           // shader playback time (in seconds)
uniform float     iTimeDelta;            // render time (in seconds)
uniform int       iFrame;                // shader playback frame
uniform float     iChannelTime[4];       // channel playback time (in seconds)
uniform vec3      iChannelResolution[4]; // channel resolution (in pixels)
uniform vec4      iMouse;                // mouse pixel coords. xy: current (if MLB down), zw: click

//uniform samplerXX iChannel0..3;          // input channel. XX = 2D/Cube
uniform sampler2D iChannel0;
uniform sampler2D iChannel1;
uniform sampler2D iChannel2;
uniform sampler2D iChannel3;

uniform vec4      iDate;                 // (year, month, day, time in seconds)
uniform float     iSampleRate;           // sound sample rate (i.e., 44100)

#define TESTS 50.0
void main(  )
{
	vec2 uv = gl_FragCoord.xy / iResolution.xy;
    float t = iGlobalTime;
    vec4 c = vec4(0.0);
    for(float i = 0.; i< TESTS; i++){
    	c.rgb = max(c.rgb,
                sin(i/40.+
                    6.28*(vec3(0.,.33,.66)+
                       texture2D(
                            iChannel0,vec2(
                                uv.x,uv.y-(i/iResolution.y))
                        ).rgb
                    ))*.5+.5);   
    }
   	c.rgb = sin(( vec3(0.,.33,.66)+c.rgb+uv.y)*6.28)*.5+.5;
    c.a = 1.0;
	gl_FragColor = c;
}
