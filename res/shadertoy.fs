// Created by inigo quilez - 2015
// License Creative Commons Attribution-NonCommercial-ShareAlike 3.0


#define AA 1

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



void main()
{
	//fragCoord to gl_FragCoord
	
		vec2 uv = (gl_FragCoord.xy - iResolution.xy * .5) / iResolution.y;
	    vec3 p = vec3(0.,0.,-2.5);
	    vec3 d = vec3(uv,1.);
	    vec3 sp = vec3(sin(iGlobalTime),0.,0.);
	    int id = -1;
	    for(int i = 0; i < 256; i++) {
	    	float dst = length(sp-p) - 1.;
	        p += d * dst * .75;
	        if(dst < .001) {
	            id = 0;
	            break;
	        }
	    }
	    gl_FragColor = vec4(uv,0.5+0.5*sin(iGlobalTime),1.0);
	    if(id == 0) {
	        vec3 n = normalize(p-sp);
	        vec3 r = normalize(reflect(d,n));
	        vec3 ld = normalize(vec3(45.,30.,-45.));
	        float d = max(dot(ld,n), 0.);
	        float s = max(pow(dot(ld,r),20.),0.);
	        gl_FragColor.xyz = vec3(1.,0.,0.)*d+(s*d);
	    }
	
    //fragColor = vec4(color, 1.0); muss so aussehen
}