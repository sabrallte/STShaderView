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


vec3 srgb2lin(vec3 c) { return c*c; }
vec3 lin2srgb(vec3 c) { return sqrt(c); }

void main(  )
{
	vec2 uv = gl_FragCoord.xy / iResolution.xy;
	
    vec3 s0 = srgb2lin(texture2D( iChannel0, uv, -10.0 ).rgb);
    vec3 s1 = srgb2lin(texture2D( iChannel1, uv, -10.0 ).rgb);

    vec3 s2 = srgb2lin(texture2D( iChannel2, uv, -10.0 ).rgb);
    vec3 s3 = srgb2lin(texture2D( iChannel3, uv, -10.0 ).rgb);

    //gl_FragColor = vec4( lin2srgb(s0), 1.0 ); return; //DEBUG
    //gl_FragColor = vec4( lin2srgb(s2), 1.0 ); return; //DEBUG
    
    gl_FragColor = vec4( lin2srgb( min( s1, s3 ) ), 1.0 ); //octagon
    //gl_FragColor = vec4( lin2srgb( max( s1, s3 ) ), 1.0 ); //star
}
