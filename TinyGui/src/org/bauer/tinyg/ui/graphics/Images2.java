package org.bauer.tinyg.ui.graphics;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

public enum Images2 {
	accept("01_core_accept","ic_action_accept"),
	call("01_core_call","ic_action_call"),
	cancel("01_core_cancel","ic_action_cancel"),
	copy("01_core_copy","ic_action_copy"),
	cut("01_core_cut","ic_action_cut"),
	discard("01_core_discard","ic_action_discard"),
	edit("01_core_edit","ic_action_edit"),
	newAction("01_core_new","ic_action_new"),
	overflow("01_core_overflow","ic_action_overflow"),
	paste("01_core_paste","ic_action_paste"),
	refresh("01_core_refresh","ic_action_refresh"),
	remove("01_core_remove","ic_action_remove"),
	search("01_core_search","ic_action_search"),
	select_all("01_core_select_all","ic_action_select_all"),
	share("01_core_share","ic_action_share"),
	undo("01_core_undo","ic_action_undo"),
	back("02_navigation_back","ic_action_back"),
	collapse("02_navigation_collapse","ic_action_collapse"),
	expand("02_navigation_expand","ic_action_expand"),
	forward("02_navigation_forward","ic_action_forward"),
	next_item("02_navigation_next_item","ic_action_next_item"),
	previous_item("02_navigation_previous_item","ic_action_previous_item"),
	bad("03_rating_bad","ic_action_bad"),
	favorite("03_rating_favorite","ic_action_favorite"),
	good("03_rating_good","ic_action_good"),
	half_important("03_rating_half_important","ic_action_half_important"),
	important("03_rating_important","ic_action_important"),
	not_important("03_rating_not_important","ic_action_not_important"),
	cloud("04_collections_cloud","ic_action_cloud"),
	collection("04_collections_collection","ic_action_collection"),
	go_to_today("04_collections_go_to_today","ic_action_go_to_today"),
	labels("04_collections_labels","ic_action_labels"),
	new_label("04_collections_new_label","ic_action_new_label"),
	sort_by_size("04_collections_sort_by_size","ic_action_sort_by_size"),
	view_as_grid("04_collections_view_as_grid","ic_action_view_as_grid"),
	view_as_list("04_collections_view_as_list","ic_action_view_as_list"),
	attachment("05_content_attachment","ic_action_attachment"),
	backspace("05_content_backspace","ic_action_backspace"),
	email("05_content_email","ic_action_email"),
	event("05_content_event","ic_action_event"),
	import_export("05_content_import_export","ic_action_import_export"),
	merge("05_content_merge","ic_action_merge"),
	new_attachment("05_content_new_attachment","ic_action_new_attachment"),
	new_email("05_content_new_email","ic_action_new_email"),
	new_event("05_content_new_event","ic_action_new_event"),
	new_picture("05_content_new_picture","ic_action_new_picture"),
	picture("05_content_picture","ic_action_picture"),
	read("05_content_read","ic_action_read"),
	save("05_content_save","ic_action_save"),
	split("05_content_split","ic_action_split"),
	unread("05_content_unread","ic_action_unread"),
	add_group("06_social_add_group","ic_action_add_group"),
	add_person("06_social_add_person","ic_action_add_person"),
	cc_bcc("06_social_cc_bcc","ic_action_cc_bcc"),
	chat("06_social_chat","ic_action_chat"),
	group("06_social_group","ic_action_group"),
	person("06_social_person","ic_action_person"),
	reply("06_social_reply","ic_action_reply"),
	reply_all("06_social_reply_all","ic_action_reply_all"),
	send_now("06_social_send_now","ic_action_send_now"),
	directions("07_location_directions","ic_action_directions"),
	location_found("07_location_location_found","ic_action_location_found"),
	location_off("07_location_location_off","ic_action_location_off"),
	location_searching("07_location_location_searching","ic_action_location_searching"),
	map("07_location_map","ic_action_map"),
	place("07_location_place","ic_action_place"),
	web_site("07_location_web_site","ic_action_web_site"),
	camera("08_camera_camera","ic_action_camera"),
	crop("08_camera_crop","ic_action_crop"),
	flash_automatic("08_camera_flash_automatic","ic_action_flash_automatic"),
	flash_off("08_camera_flash_off","ic_action_flash_off"),
	flash_on("08_camera_flash_on","ic_action_flash_on"),
	mic("08_camera_mic","ic_action_mic"),
	mic_muted("08_camera_mic_muted","ic_action_mic_muted"),
	rotate_left("08_camera_rotate_left","ic_action_rotate_left"),
	rotate_right("08_camera_rotate_right","ic_action_rotate_right"),
	switch_camera("08_camera_switch_camera","ic_action_switch_camera"),
	switch_video("08_camera_switch_video","ic_action_switch_video"),
	video("08_camera_video","ic_action_video"),
	add_to_queue("09_media_add_to_queue","ic_action_add_to_queue"),
	cast("09_media_cast","ic_action_cast"),
	download("09_media_download","ic_action_download"),
	fast_forward("09_media_fast_forward","ic_action_fast_forward"),
	full_screen("09_media_full_screen","ic_action_full_screen"),
	make_available_offline("09_media_make_available_offline","ic_action_make_available_offline"),
	next("09_media_next","ic_action_next"),
	pause("09_media_pause","ic_action_pause"),
	pause_over_video("09_media_pause_over_video","ic_action_pause_over_video"),
	play("09_media_play","ic_action_play"),
	play_over_video("09_media_play_over_video","ic_action_play_over_video"),
	previous("09_media_previous","ic_action_previous"),
	repeat("09_media_repeat","ic_action_repeat"),
	replay("09_media_replay","ic_action_replay"),
	return_from_full_screen("09_media_return_from_full_screen","ic_action_return_from_full_screen"),
	rewind("09_media_rewind","ic_action_rewind"),
	shuffle("09_media_shuffle","ic_action_shuffle"),
	slideshow("09_media_slideshow","ic_action_slideshow"),
	stop("09_media_stop","ic_action_stop"),
	upload("09_media_upload","ic_action_upload"),
	volume_muted("09_media_volume_muted","ic_action_volume_muted"),
	volume_on("09_media_volume_on","ic_action_volume_on"),
	accounts("10_device_access_accounts","ic_action_accounts"),
	add_alarm("10_device_access_add_alarm","ic_action_add_alarm"),
	airplane_mode_off("10_device_access_airplane_mode_off","ic_action_airplane_mode_off"),
	airplane_mode_on("10_device_access_airplane_mode_on","ic_action_airplane_mode_on"),
	alarms("10_device_access_alarms","ic_action_alarms"),
	battery("10_device_access_battery","ic_action_battery"),
	bightness_low("10_device_access_bightness_low","ic_action_bightness_low"),
	bluetooth("10_device_access_bluetooth","ic_action_bluetooth"),
	bluetooth_connected("10_device_access_bluetooth_connected","ic_action_bluetooth_connected"),
	bluetooth_searching("10_device_access_bluetooth_searching","ic_action_bluetooth_searching"),
	brightness_auto("10_device_access_brightness_auto","ic_action_brightness_auto"),
	brightness_high("10_device_access_brightness_high","ic_action_brightness_high"),
	brightness_medium("10_device_access_brightness_medium","ic_action_brightness_medium"),
	data_usage("10_device_access_data_usage","ic_action_data_usage"),
	dial_pad("10_device_access_dial_pad","ic_action_dial_pad"),
	end_call("10_device_access_end_call","ic_action_end_call"),
	network_cell("10_device_access_network_cell","ic_action_network_cell"),
	network_wifi("10_device_access_network_wifi","ic_action_network_wifi"),
	new_account("10_device_access_new_account","ic_action_new_account"),
	not_secure("10_device_access_not_secure","ic_action_not_secure"),
	ring_volume("10_device_access_ring_volume","ic_action_ring_volume"),
	screen_locked_to_landscape("10_device_access_screen_locked_to_landscape","ic_action_screen_locked_to_landscape"),
	screen_locked_to_portrait("10_device_access_screen_locked_to_portrait","ic_action_screen_locked_to_portrait"),
	screen_rotation("10_device_access_screen_rotation","ic_action_screen_rotation"),
	sd_storage("10_device_access_sd_storage","ic_action_sd_storage"),
	secure("10_device_access_secure","ic_action_secure"),
	storage("10_device_access_storage","ic_action_storage"),
	time("10_device_access_time","ic_action_time"),
	usb("10_device_access_usb","ic_action_usb"),
	computer("11_hardware_computer","ic_action_computer"),
	dock("11_hardware_dock","ic_action_dock"),
	gamepad("11_hardware_gamepad","ic_action_gamepad"),
	headphones("11_hardware_headphones","ic_action_headphones"),
	headset("11_hardware_headset","ic_action_headset"),
	keyboard("11_hardware_keyboard","ic_action_keyboard"),
	mouse("11_hardware_mouse","ic_action_mouse"),
	phone("11_hardware_phone","ic_action_phone"),
	error("12_alerts_and_states_error","ic_action_error"),
	warning("12_alerts_and_states_warning","ic_action_warning"),
	about("13_extra_actions_about","ic_action_about"),
	help("13_extra_actions_help","ic_action_help"),
	settings("13_extra_actions_settings","ic_action_settings"),


	;
	
	
	private String name;
	private String path;
	private Image hdpi;
	private Image mdpi;
	private Image xhdpi;
	private Image xxhdpi;
	
	private Images2(String path, String name) {
		this.path = path;
		this.name = name;
	}
	
	public Image getMdpi() {
		mdpi = load("holo_dark\\" + path +"\\drawable-mdpi\\"+name + ".png", mdpi);
		return mdpi;
	}

	public Image getHdpi() {
		hdpi = load("holo_dark\\" + path +"\\drawable-hdpi\\"+name + ".png", hdpi);
		return hdpi;
	}

	public Image getxHdpi() {
		xhdpi = load("holo_dark\\" + path +"\\drawable-xhdpi\\"+name + ".png", xhdpi);
		return xhdpi;
	}

	public Image getxxHdpi() {
		xxhdpi = load("holo_dark\\" + path +"\\drawable-xxhdpi\\"+name + ".png", xxhdpi);
		return xxhdpi;
	}
	
	private Image load(String fullpath, Image old) {
		if (old != null && old.isDisposed() == false) {
			return old;
		}
		InputStream in = getClass().getResourceAsStream(fullpath);
		if (in == null) {
			throw new Error("BAD CONFIG FOR " + fullpath);
		}
		ImageData data  = new ImageLoader().load(in)[0];
		return new Image(Display.getCurrent(), data);
	}
}
