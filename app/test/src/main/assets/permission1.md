

$ adb shell pm list permissions -g -f

All Permissions:

+ group:com.google.android.gms.permission.CAR_INFORMATION
  package:com.google.android.gms
  label:Car information
  description:Access your car's information
  + permission:com.google.android.gms.permission.CAR_VENDOR_EXTENSION
    package:com.google.android.gms
    label:car vendor channel
    description:Access your car's vendor channel to exchange car-specific information
    protectionLevel:dangerous
  + permission:com.google.android.gms.permission.CAR_MILEAGE
    package:com.google.android.gms
    label:car mileage
    description:Access your car's mileage information
    protectionLevel:dangerous
  + permission:com.google.android.gms.permission.CAR_FUEL
    package:com.google.android.gms
    label:car fuel level
    description:Access your car's fuel level information
    protectionLevel:dangerous

+ group:android.permission-group.CONTACTS
  package:android
  label:Contacts
  description:access your contacts
  + permission:android.permission.WRITE_CONTACTS
    package:android
    label:modify your contacts
    description:Allows the app to modify the data about your contacts stored on your phone, including the frequency with which you've called, emailed, or communicated in other ways with specific contacts. This permission allows apps to delete contact data.
    protectionLevel:dangerous
  + permission:android.permission.GET_ACCOUNTS
    package:android
    label:find accounts on the device
    description:Allows the app to get the list of accounts known by the phone. This may include any accounts created by applications you have installed.
    protectionLevel:dangerous
  + permission:android.permission.READ_CONTACTS
    package:android
    label:read your contacts
    description:Allows the app to read data about your contacts stored on your phone, including the frequency with which you've called, emailed, or communicated in other ways with specific individuals. This permission allows apps to save your contact data, and malicious apps may share contact data without your knowledge.
    protectionLevel:dangerous

+ group:android.permission-group.PHONE
  package:android
  label:Phone
  description:make and manage phone calls
  + permission:android.permission.READ_CALL_LOG
    package:android
    label:read call log
    description:Allows the app to read your phone's call log, including data about incoming and outgoing calls. This permission allows apps to save your call log data, and malicious apps may share call log data without your knowledge.
    protectionLevel:dangerous
  + permission:android.permission.ACCESS_UCE_OPTIONS_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_PHONE_STATE
    package:android
    label:read phone status and identity
    description:Allows the app to access the phone features of the device. This permission allows the app to determine the phone number and device IDs, whether a call is active, and the remote number connected by a call.
    protectionLevel:dangerous
  + permission:android.permission.ACCESS_IMS_CALL_SERVICE
    package:android
    label:access IMS call service
    description:Allows the app to use the IMS service to make calls without your intervention.
    protectionLevel:signature|privileged
  + permission:android.permission.CALL_PHONE
    package:android
    label:directly call phone numbers
    description:Allows the app to call phone numbers without your intervention. This may result in unexpected charges or calls. Note that this doesn't allow the app to call emergency numbers. Malicious apps may cost you money by making calls without your confirmation.
    protectionLevel:dangerous
  + permission:android.permission.ACCESS_UCE_PRESENCE_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_CALL_LOG
    package:android
    label:write call log
    description:Allows the app to modify your phone's call log, including data about incoming and outgoing calls. Malicious apps may use this to erase or modify your call log.
    protectionLevel:dangerous
  + permission:android.permission.USE_SIP
    package:android
    label:make/receive SIP calls
    description:Allows the app to make and receive SIP calls.
    protectionLevel:dangerous
  + permission:android.permission.PROCESS_OUTGOING_CALLS
    package:android
    label:reroute outgoing calls
    description:Allows the app to see the number being dialed during an outgoing call with the option to redirect the call to a different number or abort the call altogether.
    protectionLevel:dangerous
  + permission:com.android.voicemail.permission.ADD_VOICEMAIL
    package:android
    label:add voicemail
    description:Allows the app to add messages to your voicemail inbox.
    protectionLevel:dangerous

+ group:android.permission-group.CALENDAR
  package:android
  label:Calendar
  description:access your calendar
  + permission:android.permission.READ_CALENDAR
    package:android
    label:read calendar events plus confidential information
    description:Allows the app to read all calendar events stored on your phone, including those of friends or co-workers. This may allow the app to share or save your calendar data, regardless of confidentiality or sensitivity.
    protectionLevel:dangerous
  + permission:android.permission.WRITE_CALENDAR
    package:android
    label:add or modify calendar events and send email to guests without owners' knowledge
    description:Allows the app to add, remove, change events that you can modify on your phone, including those of friends or co-workers. This may allow the app to send messages that appear to come from calendar owners, or modify events without the owners' knowledge.
    protectionLevel:dangerous

+ group:android.permission-group.CAMERA
  package:android
  label:Camera
  description:take pictures and record video
  + permission:android.permission.CAMERA
    package:android
    label:take pictures and videos
    description:Allows the app to take pictures and videos with the camera. This permission allows the app to use the camera at any time without your confirmation.
    protectionLevel:dangerous

+ group:android.permission-group.SENSORS
  package:android
  label:Body Sensors
  description:access sensor data about your vital signs
  + permission:android.permission.BODY_SENSORS
    package:android
    label:access body sensors (like heart rate monitors)
    description:Allows the app to access data from sensors that monitor your physical condition, such as your heart rate.
    protectionLevel:dangerous
  + permission:android.permission.USE_FINGERPRINT
    package:android
    label:use fingerprint hardware
    description:Allows the app to use fingerprint hardware for authentication
    protectionLevel:normal

+ group:android.permission-group.LOCATION
  package:android
  label:Location
  description:access this device's location
  + permission:android.permission.ACCESS_FINE_LOCATION
    package:android
    label:access precise location (GPS and network-based)
    description:Allows the app to get your precise location using the Global Positioning System (GPS) or network location sources such as cell towers and Wi-Fi. These location services must be turned on and available to your device for the app to use them. Apps may use this to determine where you are, and may consume additional battery power.
    protectionLevel:dangerous
  + permission:com.google.android.gms.permission.CAR_SPEED
    package:com.google.android.gms
    label:car speed
    description:Access your car's speed
    protectionLevel:dangerous
  + permission:android.permission.ACCESS_COARSE_LOCATION
    package:android
    label:access approximate location (network-based)
    description:Allows the app to get your approximate location. This location is derived by location services using network location sources such as cell towers and Wi-Fi. These location services must be turned on and available to your device for the app to use them. Apps may use this to determine approximately where you are.
    protectionLevel:dangerous

+ group:android.permission-group.STORAGE
  package:android
  label:Storage
  description:access photos, media, and files on your device
  + permission:android.permission.READ_EXTERNAL_STORAGE
    package:android
    label:read the contents of your USB storage
    description:Allows the app to read the contents of your USB storage.
    protectionLevel:dangerous
  + permission:android.permission.WRITE_EXTERNAL_STORAGE
    package:android
    label:modify or delete the contents of your USB storage
    description:Allows the app to write to the USB storage.
    protectionLevel:dangerous

+ group:android.permission-group.MICROPHONE
  package:android
  label:Microphone
  description:record audio
  + permission:android.permission.RECORD_AUDIO
    package:android
    label:record audio
    description:Allows the app to record audio with the microphone. This permission allows the app to record audio at any time without your confirmation.
    protectionLevel:dangerous

+ group:android.permission-group.SMS
  package:android
  label:SMS
  description:send and view SMS messages
  + permission:android.permission.READ_SMS
    package:android
    label:read your text messages (SMS or MMS)
    description:Allows the app to read SMS messages stored on your phone or SIM card. This allows the app to read all SMS messages, regardless of content or confidentiality.
    protectionLevel:dangerous
  + permission:android.permission.RECEIVE_WAP_PUSH
    package:android
    label:receive text messages (WAP)
    description:Allows the app to receive and process WAP messages. This permission includes the ability to monitor or delete messages sent to you without showing them to you.
    protectionLevel:dangerous
  + permission:android.permission.RECEIVE_MMS
    package:android
    label:receive text messages (MMS)
    description:Allows the app to receive and process MMS messages. This means the app could monitor or delete messages sent to your device without showing them to you.
    protectionLevel:dangerous
  + permission:android.permission.RECEIVE_SMS
    package:android
    label:receive text messages (SMS)
    description:Allows the app to receive and process SMS messages. This means the app could monitor or delete messages sent to your device without showing them to you.
    protectionLevel:dangerous
  + permission:android.permission.SEND_SMS
    package:android
    label:send and view SMS messages
    description:Allows the app to send SMS messages. This may result in unexpected charges. Malicious apps may cost you money by sending messages without your confirmation.
    protectionLevel:dangerous
  + permission:android.permission.READ_CELL_BROADCASTS
    package:android
    label:read cell broadcast messages
    description:Allows the app to read cell broadcast messages received by your device. Cell broadcast alerts are delivered in some locations to warn you of emergency situations. Malicious apps may interfere with the performance or operation of your device when an emergency cell broadcast is received.
    protectionLevel:dangerous

+ ungrouped:
  + permission:android.permission.REAL_GET_TASKS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_CACHE_FILESYSTEM
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.REMOTE_AUDIO_PLAYBACK
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.synaptics.permission.FINGERPRINT
    package:com.motorola.motocit
    label:Access fingerprint reader.
    description:Allows application to access fingerprint reader.
    protectionLevel:signature|privileged
  + permission:com.devhd.feedly.permission.C2D_MESSAGE
    package:com.devhd.feedly
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.photos.permission.C2D_MESSAGE
    package:com.google.android.apps.photos
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REGISTER_WINDOW_MANAGER_LISTENERS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.INTENT_FILTER_VERIFICATION_AGENT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_INCALL_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.trustagent.framework.model.DATA_CHANGE_NOTIFICATION
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.WRITE_SETTINGS
    package:android
    label:modify system settings
    description:Allows the app to modify the system's settings data. Malicious apps may corrupt your system's configuration.
    protectionLevel:signature|appop|pre23|preinstalled
  + permission:com.google.android.vending.verifier.ACCESS_VERIFIER
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CONTROL_KEYGUARD
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.calendar.permission.C2D_MESSAGE
    package:com.google.android.calendar
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CONFIGURE_WIFI_DISPLAY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CONFIGURE_DISPLAY_COLOR_MODE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_WIMAX_STATE
    package:android
    label:connect and disconnect from WiMAX
    description:Allows the app to determine whether WiMAX is enabled and information about any WiMAX networks that are connected.
    protectionLevel:normal
  + permission:android.permission.SET_INPUT_CALIBRATION
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RECOVERY
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.TEMPORARY_ENABLE_ACCESSIBILITY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SET_PROCESS_LIMIT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:com.qualcomm.permission.ATCMD
    package:com.qualcomm.atfwd
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.googlequicksearchbox.permission.C2D_MESSAGE
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.FRAME_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gm.permission.BROADCAST_INTERNAL
    package:com.google.android.gm
    label:internal broadcast
    description:Allow the app to access Gmail broadcast intents, used to update notifications among other things.
    protectionLevel:signature
  + permission:com.google.android.gms.permission.APPINDEXING
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BRICK
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.vzw.APNPERMISSION
    package:com.vzw.apnservice
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_PRINT_RECOMMENDATION_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RESTART_PACKAGES
    package:android
    label:close other apps
    description:Allows the app to end background processes of other apps. This may cause other apps to stop running.
    protectionLevel:normal
  + permission:android.permission.STORAGE_INTERNAL
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.USE_CREDENTIALS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.TABLET_MODE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_KEYGUARD_APPWIDGET
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.qq.qcloud.permission.C2D_MESSAGE
    package:com.qq.qcloud
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_DEVICE_ADMIN
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MODIFY_AUDIO_SETTINGS
    package:android
    label:change your audio settings
    description:Allows the app to modify global audio settings such as volume and which speaker is used for output.
    protectionLevel:normal
  + permission:android.permission.ACCESS_CHECKIN_PROPERTIES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.KILL_UID
    package:android
    label:null
    description:null
    protectionLevel:signature|installer
  + permission:android.permission.SIGNAL_PERSISTENT_PROCESSES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.BIND_PRINT_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_NOTIFICATION_POLICY
    package:android
    label:access Do Not Disturb
    description:Allows the app to read and write Do Not Disturb configuration.
    protectionLevel:normal
  + permission:com.android.permission.READ_OMADM_SETTINGS
    package:com.android.omadm.service
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_RUNTIME_PERMISSION_PRESENTER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MODIFY_AUDIO_ROUTING
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.RECEIVE_BLUETOOTH_MAP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_MOCK_LOCATION
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.enterprise.dmagent.permission.NotificationBroadcastReceiverPermission
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_VR_LISTENER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.qqhead.permission.getheadresp
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GET_APP_OPS_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.RECEIVE_DATA_ACTIVITY_CHANGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GET_PACKAGE_IMPORTANCE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_WIFI_CREDENTIAL
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.amap.sdk.protected_provider.ACCESS_DATA
    package:com.autonavi.minimap
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_DREAM_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.WRITE_GSERVICES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.printspooler.permission.ACCESS_ALL_PRINT_JOBS
    package:com.android.printspooler
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.INSTALL_LOCATION_PROVIDER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.voicesearch.AUDIO_FILE_ACCESS
    package:com.google.android.googlequicksearchbox
    label:Recorded audio access
    description:Can access the recorded audio utterances for notes to self, and for raw audio analysis.
    protectionLevel:signature
  + permission:com.eusoft.ting.en.permission.MIPUSH_RECEIVE
    package:com.eusoft.ting.en
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.qav.permission.broadcast
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.audiomonitor.permission.SETTINGS
    package:com.motorola.triggerenroll
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_ACCOUNTS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.CONTROL_WIFI_DISPLAY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SYSTEM_ALERT_WINDOW
    package:android
    label:draw over other apps
    description:Allows the app to draw on top of other applications or parts of the user interface. They may interfere with your use of the interface in any application, or change what you think you are seeing in other applications.
    protectionLevel:signature|development|appop|pre23|preinstalled
  + permission:android.permission.BIND_CARRIER_SERVICES
    package:android
    label:bind to carrier services
    description:Allows the holder to bind to carrier services. Should never be needed for normal apps.
    protectionLevel:signature|privileged
  + permission:com.google.android.gsf.subscribedfeeds.permission.C2D_MESSAGE
    package:com.google.android.gsf
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BROADCAST_PHONE_ACCOUNT_REGISTRATION
    package:com.android.server.telecom
    label:Broadcast phone account registration
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.START_TASKS_FROM_RECENTS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.apps.enterprise.dmagent.permission.AutoRegisterPermission
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CONTROL_LOCATION_UPDATES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GET_TOP_ACTIVITY_INFO
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.auth.authzen.permission.DEVICE_SYNC_FINISHED
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CLEAR_APP_USER_DATA
    package:android
    label:null
    description:null
    protectionLevel:signature|installer
  + permission:eu.chainfire.supersu.permission.NATIVE
    package:eu.chainfire.supersu
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.PROVIDE_TRUST_AGENT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BROADCAST_CALLLOG_INFO
    package:com.android.server.telecom
    label:Broadcast the call type/duration information
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.chromesync.permission.CONTENT_PROVIDER_ACCESS
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.INSTALL_PACKAGES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_SOUND_TRIGGER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SEND_RESPOND_VIA_MESSAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.permission.WHITELIST_BLUETOOTH_DEVICE
    package:com.android.bluetooth
    label:Whitelist bluetooth device access.
    description:Allows the app to temporarily whitelist a Bluetooth device, allowing that device to send files to this device without user confirmation.
    protectionLevel:signature
  + permission:android.permission.ACCESS_FM_RADIO
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_VOICE_KEYPHRASES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SHUTDOWN
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CHANGE_COMPONENT_ENABLED_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.CHECKIN_NOW
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_QUICK_SETTINGS_TILE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_TV_INPUT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.NFC
    package:android
    label:control Near Field Communication
    description:Allows the app to communicate with Near Field Communication (NFC) tags, cards, and readers.
    protectionLevel:normal
  + permission:android.permission.MODIFY_PARENTAL_CONTROLS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.INTERNAL_SYSTEM_WINDOW
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.PROCESS_PHONE_ACCOUNT_REGISTRATION
    package:com.android.server.telecom
    label:Process phone account registration
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.RETRIEVE_WINDOW_TOKEN
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.permission.SEND_ANDROID_PAY_DATA
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_WALLPAPER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.motorola.android.permission.TCMD_LOCAL
    package:com.motorola.motocit
    label:Use Test Commands
    description:Use Test Commands
    protectionLevel:signature|privileged
  + permission:android.permission.START_ANY_ACTIVITY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CAMERA_SEND_SYSTEM_EVENTS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.apps.now.OPT_IN_WIZARD
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.auth.authzen.permission.GCM_DEVICE_PROXIMITY
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.music.data.permission2
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.googlequicksearchbox.permission.FINISH_GEL_ACTIVITY
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GET_PROCESS_STATE_AND_OOM_SCORE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.BROADCAST_SMS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CALL_PRIVILEGED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_INTENT_FILTER_VERIFIER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.youku.phone.permission.MIPUSH_RECEIVE
    package:com.youku.phone
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_APP_TOKENS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CHANGE_NETWORK_STATE
    package:android
    label:change network connectivity
    description:Allows the app to change the state of network connectivity.
    protectionLevel:normal
  + permission:android.permission.CAPTURE_TV_INPUT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MASTER_CLEAR
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.PERSISTENT_ACTIVITY
    package:android
    label:make app always run
    description:Allows the app to make parts of itself persistent in memory. This can limit memory available to other apps slowing down the phone.
    protectionLevel:normal
  + permission:android.permission.BIND_TELECOM_CONNECTION_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_SYNC_SETTINGS
    package:android
    label:toggle sync on and off
    description:Allows an app to modify the sync settings for an account. For example, this can be used to enable sync of the People app with an account.
    protectionLevel:normal
  + permission:com.google.android.providers.gsf.permission.WRITE_GSERVICES
    package:com.google.android.gsf
    label:Modify Google service configuration
    description:Allows this app to modify Google service configuration data.
    protectionLevel:signature|privileged
  + permission:android.permission.SET_DEBUG_APP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.ACCESS_CONTENT_PROVIDERS_EXTERNALLY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RESET_SHORTCUT_MANAGER_THROTTLING
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RESET_FINGERPRINT_LOCKOUT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RECEIVE_BOOT_COMPLETED
    package:android
    label:run at startup
    description:Allows the app to have itself started as soon as the system has finished booting. This can make it take longer to start the phone and allow the app to slow down the overall phone by always running.
    protectionLevel:normal
  + permission:android.permission.LOOP_RADIO
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GLOBAL_SEARCH_CONTROL
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:org.codeaurora.permission.ACCESS_CSVT_SERVICE
    package:org.codeaurora.ims
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SUBSCRIBED_FEEDS_READ
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:com.google.android.gms.auth.permission.POST_SIGN_IN_ACCOUNT
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.permission.ACCESS_DRM
    package:com.motorola.motosignature.app
    label:Access DRM content.
    description:Allows application to access DRM-protected content.
    protectionLevel:signature
  + permission:android.permission.PEERS_MAC_ADDRESS
    package:android
    label:null
    description:null
    protectionLevel:signature|setup
  + permission:android.permission.DEVICE_POWER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.providers.settings.permission.READ_GSETTINGS
    package:com.google.android.gsf
    label:Read Google settings
    description:Allows this app to read Google settings.
    protectionLevel:signature
  + permission:com.tencent.mm.permission.MM_MESSAGE
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.enterprise.dmagent.permission.InvokeDMSecurityLogsServicePermission
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.cloudsave.BIND_EVENT_BROADCAST
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.vending.permission.C2D_MESSAGE
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SET_TIME_ZONE
    package:android
    label:set time zone
    description:Allows the app to change the phone's time zone.
    protectionLevel:normal
  + permission:android.permission.REMOVE_TASKS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.googlequicksearchbox.permission.PAUSE_HOTWORD
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.EXPAND_STATUS_BAR
    package:android
    label:expand/collapse status bar
    description:Allows the app to expand or collapse the status bar.
    protectionLevel:normal
  + permission:com.android.launcher.permission.UNINSTALL_SHORTCUT
    package:android
    label:uninstall shortcuts
    description:Allows the application to remove Homescreen shortcuts without user intervention.
    protectionLevel:normal
  + permission:android.permission.MANAGE_PROFILE_AND_DEVICE_OWNERS
    package:android
    label:manage profile and device owners
    description:Allows apps to set the profile owners and the device owner.
    protectionLevel:signature
  + permission:com.google.android.gms.permission.REPORT_TAP
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.READ_PROFILE
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.BIND_VOICE_INTERACTION
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.marvin.feedback.permission.TALKBACK
    package:com.google.android.marvin.talkback
    label:Control TalkBack
    description:Permission to send gestures to TalkBack and resume spoken feedback.
    protectionLevel:signature
  + permission:android.permission.BLUETOOTH
    package:android
    label:pair with Bluetooth devices
    description:Allows the app to view the configuration of the Bluetooth on the phone, and to make and accept connections with paired devices.
    protectionLevel:normal
  + permission:android.permission.BROADCAST_WAP_PUSH
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CHANGE_WIFI_MULTICAST_STATE
    package:android
    label:allow Wi-Fi Multicast reception
    description:Allows the app to receive packets sent to all devices on a Wi-Fi network using multicast addresses, not just your phone. It uses more power than the non-multicast mode.
    protectionLevel:normal
  + permission:com.google.android.onetimeinitializer.permission.ONE_TIME_INITIALIZED
    package:com.google.android.onetimeinitializer
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.DVB_DEVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.PERFORM_SIM_ACTIVATION
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.alarm.permission.SET_ALARM
    package:android
    label:set an alarm
    description:Allows the app to set an alarm in an installed alarm clock app. Some alarm clock apps may not implement this feature.
    protectionLevel:normal
  + permission:android.permission.CAPTURE_AUDIO_HOTWORD
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_MEDIA_STORAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.voicemail.permission.READ_VOICEMAIL
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_BLOCKED_NUMBERS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SET_ANIMATION_SCALE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:com.google.android.gms.permission.AD_ID_NOTIFICATION
    package:com.google.android.gms
    label:Advertising ID notification
    description:Allow an app to receive a notification when the advertising ID or limit ad tracking preference of the user is updated.
    protectionLevel:normal
  + permission:com.android.vending.setup.PLAY_SETUP_SERVICE
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GET_TASKS
    package:android
    label:retrieve running apps
    description:Allows the app to retrieve information about currently and recently running tasks. This may allow the app to discover information about which applications are used on the device.
    protectionLevel:normal
  + permission:android.permission.BROADCAST_NETWORK_PRIVILEGED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_SURFACE_FLINGER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SUBSCRIBED_FEEDS_WRITE
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:com.google.android.googleapps.permission.ACCESS_GOOGLE_PASSWORD
    package:com.google.android.gsf.login
    label:access to passwords for Google accounts
    description:Allows apps direct access to the passwords for the Google account(s) you have set up.
    protectionLevel:signature
  + permission:android.permission.AUTHENTICATE_ACCOUNTS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.INTERNET
    package:android
    label:have full network access
    description:Allows the app to create network sockets and use custom network protocols. The browser and other applications provide means to send data to the internet, so this permission is not required to send data to the internet.
    protectionLevel:normal
  + permission:android.permission.TV_INPUT_HARDWARE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.vending.INTENT_VENDING_ONLY
    package:com.google.android.gsf
    label:Send broadcasts to Android Market.
    description:Can send broadcasts to Android Market requesting app installation and removal.
    protectionLevel:signature
  + permission:android.permission.TRANSMIT_IR
    package:android
    label:transmit infrared
    description:Allows the app to use the phone's infrared transmitter.
    protectionLevel:normal
  + permission:com.google.android.gms.permission.C2D_MESSAGE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RETRIEVE_WINDOW_CONTENT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.permission.CONNMO_SETTINGS
    package:com.android.sdm.plugins.connmo
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.qq.qcloud.push.permission.MESSAGE
    package:com.qq.qcloud
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REORDER_TASKS
    package:android
    label:reorder running apps
    description:Allows the app to move tasks to the foreground and background. The app may do this without your input.
    protectionLevel:normal
  + permission:com.android.browser.permission.READ_HISTORY_BOOKMARKS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:com.qq.qcloud.permission.MIPUSH_RECEIVE
    package:com.qq.qcloud
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GET_INTENT_SENDER_INTENT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.chrome.permission.CHILD_SERVICE
    package:com.android.chrome
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.gcs.permission.BROADCAST_NETWORK_SCORES
    package:com.google.android.apps.gcs
    label:broadcast network scores
    description:null
    protectionLevel:signature
  + permission:android.permission.BLUETOOTH_ADMIN
    package:android
    label:access Bluetooth settings
    description:Allows the app to configure the local Bluetooth phone, and to discover and pair with remote devices.
    protectionLevel:normal
  + permission:android.permission.CONTROL_VPN
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.UPDATE_DEVICE_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BLUETOOTH_STACK
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BLUETOOTH_MAP
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_PRECISE_PHONE_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.auth.api.signin.permission.REVOCATION_NOTIFICATION
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.magictether.permission.CONNECTED_HOST_CHANGED
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_FINGERPRINT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.partnersetup.permission.UPDATE_CLIENT_ID
    package:com.google.android.partnersetup
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.CONTACTS_SYNC_DELEGATION
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.audiomonitor.permission.STATE_CONTROL
    package:com.motorola.triggerenroll
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.NET_ADMIN
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.permission.GAMES_DEBUG_SETTINGS
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CARRIER_FILTER_SMS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.WRITE_VERIFY_APPS_CONSENT
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.PERFORM_CDMA_PROVISIONING
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.trustagent.permission.TRUSTAGENT_STATE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_CONNECTION_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.INSTALL_GRANT_RUNTIME_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|installer|verifier
  + permission:android.permission.WRITE_SOCIAL_STREAM
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.LAUNCH_TRUST_AGENT_SETTINGS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.REGISTER_CALL_PROVIDER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GET_PACKAGE_SIZE
    package:android
    label:measure app storage space
    description:Allows the app to retrieve its code, data, and cache sizes
    protectionLevel:normal
  + permission:android.permission.CLEAR_APP_GRANTED_URI_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_VPN_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.TRUST_LISTENER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCOUNT_MANAGER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_USB
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.partnersetup.permission.WRITE_APP_PROVIDER
    package:com.google.android.partnersetup
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.motorola.permission.CAMERA_DUMP
    package:com.motorola.motosignature.app
    label:Allows an application to retrieve internal state information from the camera service.
    description:Retrieve internal camera state
    protectionLevel:signature|privileged
  + permission:android.permission.INTERACT_ACROSS_USERS_FULL
    package:android
    label:null
    description:null
    protectionLevel:signature|installer
  + permission:android.permission.BIND_APPWIDGET
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.STOP_APP_SWITCHES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.RECEIVE_MEDIA_RESOURCE_USAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BATTERY_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:com.google.android.gms.permission.INTERNAL_BROADCAST
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.PACKAGE_USAGE_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development|appop
  + permission:android.permission.WRITE_PROFILE
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.MOUNT_UNMOUNT_FILESYSTEMS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GET_ACCOUNTS_PRIVILEGED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.msf.service.permission
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.TETHER_PRIVILEGED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_SECURE_SETTINGS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:com.android.vending.TOS_ACKED
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SERIAL_PORT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_NOTIFICATION_LISTENER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_SCREENING_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.apps.gcs.WRITE_EXPERIMENTS
    package:com.google.android.apps.gcs
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.motocare.ACCESS_MOTOCARE
    package:com.motorola.motosignature.app
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.mm.plugin.permission.READ
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CAPTURE_AUDIO_OUTPUT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_MIDI_DEVICE_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.mm.wear.message
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MOVE_PACKAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.mm.ext.permission.SPORT
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.SET_ACTIVITY_WATCHER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.mm.ext.permission.WRITE
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_BLOCKED_NUMBERS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.STATUS_BAR_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.apps.helprtc.INTERNAL_BROADCAST
    package:com.google.android.apps.helprtc
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_SEARCH_INDEXABLES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.permission.WRITE_OMADM_SETTINGS
    package:com.android.omadm.service
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.msg.permission.pushnotify
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:com.devhd.feedly.permission.SESSION_READ
    package:com.devhd.feedly
    label:Read Feedly Cloud Session
    description:This permission allows the application to communicate with your Feedly Cloud session.
    protectionLevel:signature
  + permission:android.permission.NFC_HANDOVER_STATUS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SCORE_NETWORKS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.DIAGNOSTIC
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_LOCATION_EXTRA_COMMANDS
    package:android
    label:access extra location provider commands
    description:Allows the app to access extra location provider commands. This may allow the app to interfere with the operation of the GPS or other location sources.
    protectionLevel:normal
  + permission:android.permission.RECEIVE_WIFI_CREDENTIAL_CHANGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_PRIVILEGED_PHONE_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.UPDATE_LOCK_TASK_PACKAGES
    package:android
    label:null
    description:null
    protectionLevel:signature|setup
  + permission:android.permission.BROADCAST_STICKY
    package:android
    label:send sticky broadcast
    description:Allows the app to send sticky broadcasts, which remain after the broadcast ends. Excessive use may make the phone slow or unstable by causing it to use too much memory.
    protectionLevel:normal
  + permission:com.google.android.gms.magictether.permission.TEST_NOTIFICATION
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ASEC_ACCESS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_REMOTE_DISPLAY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BLUETOOTH_PRIVILEGED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.CAR
    package:com.google.android.gms
    label:Car Service
    description:Access to the car service.
    protectionLevel:signature
  + permission:android.permission.SET_ALWAYS_FINISH
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:com.tencent.mm.nfc.permission.TECH_DISCOVERED
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.HARDWARE_TEST
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_NOTIFICATION_RANKER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.permission.VOLUME_SETTING
    package:com.motorola.motosignature.app
    label:Allows defintion of the volume panel and hardware key behavior
    description:Define Volume Settings
    protectionLevel:signature|privileged
  + permission:android.permission.ASEC_CREATE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.enterprise.dmagent.permission.AutoSyncPermission
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.apps.enterprise.dmagent.permission.InvokeDMServicePermission
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.WRITE_SMS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:org.videolan.vlc.permission.READ_EXTENSION_DATA
    package:org.videolan.vlc
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.SUBSTITUTE_NOTIFICATION_APP_NAME
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.intent.category.MASTER_CLEAR.permission.C2D_MESSAGE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_KEYGUARD_SECURE_STORAGE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.launcher.permission.CONTENT_REDIRECT
    package:com.google.android.launcher
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_JOB_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CONFIRM_FULL_BACKUP
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CAPTURE_SECURE_VIDEO_OUTPUT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SET_TIME
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.WRITE_APN_SETTINGS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.providers.settings.permission.WRITE_GSETTINGS
    package:com.google.android.gsf
    label:Modify Google settings
    description:Allows this app to modify Google settings.
    protectionLevel:signature
  + permission:android.permission.CHANGE_WIFI_STATE
    package:android
    label:connect and disconnect from Wi-Fi
    description:Allows the app to connect to and disconnect from Wi-Fi access points and to make changes to device configuration for Wi-Fi networks.
    protectionLevel:normal
  + permission:com.android.permission.INJECT_OMADM_SETTINGS
    package:com.android.omadm.service
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.motorola.permission.REGISTER_SMART_NOTIFICATIONS
    package:com.motorola.motosignature.app
    label:Register with smart notifications
    description:Allows end point apps signed with Motorola signature to register with sync engine of smart notifications
    protectionLevel:signature
  + permission:com.google.android.apps.gcs.RECEIVE_GCS_STATE
    package:com.google.android.apps.gcs
    label:receive GCS state
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_PACKAGE_VERIFIER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_INSTALL_SESSIONS
    package:android
    label:read install sessions
    description:Allows an application to read install sessions. This allows it to see details about active package installations.
    protectionLevel:normal
  + permission:android.permission.MODIFY_CELL_BROADCASTS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MODIFY_DAY_NIGHT_MODE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_ROUTE_PROVIDER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RECEIVE_STK_COMMANDS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GET_PASSWORD
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_CARRIER_MESSAGING_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_BLUETOOTH_SHARE
    package:com.android.bluetooth
    label:Access download manager.
    description:Allows the app to access the BluetoothShare manager and use it to transfer files.
    protectionLevel:signature
  + permission:android.permission.PACKAGE_VERIFICATION_AGENT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SET_ORIENTATION
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REVOKE_RUNTIME_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|installer|verifier
  + permission:android.permission.MANAGE_USERS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.vending.billing.BILLING_ACCOUNT_SERVICE
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.qti.permission.DIAG
    package:org.codeaurora.ims
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gm.email.permission.ACCESS_PROVIDER
    package:com.google.android.gm
    label:Access email provider data
    description:Allows the app to access your email database, including received messages, sent messages, usernames, and passwords.
    protectionLevel:signature
  + permission:android.permission.SET_PREFERRED_APPLICATIONS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_TV_REMOTE_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.FLASHLIGHT
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.DELETE_CACHE_FILES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SET_WALLPAPER_COMPONENT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_NETWORK_STATE
    package:android
    label:view network connections
    description:Allows the app to view information about network connections such as which networks exist and are connected.
    protectionLevel:normal
  + permission:android.permission.BIND_CONDITION_PROVIDER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_MTP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.DISABLE_KEYGUARD
    package:android
    label:disable your screen lock
    description:Allows the app to disable the keylock and any associated password security. For example, the phone disables the keylock when receiving an incoming phone call, then re-enables the keylock when the call is finished.
    protectionLevel:normal
  + permission:android.permission.BACKUP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.PROCESS_CALLLOG_INFO
    package:com.android.server.telecom
    label:Register to handle the broadcasted call type/duration information
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CHANGE_CONFIGURATION
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.USER_ACTIVITY
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.LOCAL_MAC_ADDRESS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.SHOW_PAYMENT_CARD_DETAILS
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_LOGS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.COPY_PROTECTED_DATA
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.magictether.permission.SCANNED_DEVICE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ASEC_DESTROY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.INTERACT_ACROSS_USERS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.SET_WALLPAPER
    package:android
    label:set wallpaper
    description:Allows the app to set the system wallpaper.
    protectionLevel:normal
  + permission:com.autonavi.minimap.permission.RECV_MESSAGE
    package:com.autonavi.minimap
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.ASEC_RENAME
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SET_KEYBOARD_LAYOUT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.UPDATE_CONFIG
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_NETWORK_CONDITIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.taobao.taobao.permission.MIPUSH_RECEIVE
    package:com.taobao.taobao
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_DREAM_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.QUERY_DO_NOT_ASK_CREDENTIALS_ON_BOOT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:cmb.pb.permission.HCE_PUSH_MESSAGE
    package:cmb.pb
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.launcher.permission.RECEIVE_FIRST_LOAD_BROADCAST
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.UPDATE_LOCK
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:org.linphone.permission.C2D_MESSAGE
    package:cmb.pb
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_NETWORK_USAGE_HISTORY
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_DRM_CERTIFICATES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.mm.permission.C2D_MESSAGE
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gsf.permission.C2D_MESSAGE
    package:com.google.android.gsf
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.googlequicksearchbox.permission.FLUSH_LOGS
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.docs.editors.punch.permission.WRITE_IMAGES
    package:com.google.android.apps.docs.editors.slides
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.TV_VIRTUAL_REMOTE_CONTROLLER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_APP_OPS_RESTRICTIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|installer
  + permission:android.permission.READ_INPUT_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.KILL_BACKGROUND_PROCESSES
    package:android
    label:close other apps
    description:Allows the app to end background processes of other apps. This may cause other apps to stop running.
    protectionLevel:normal
  + permission:android.permission.CACHE_CONTENT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_VOICE_INTERACTION_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_PRINT_SPOOLER_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_DIRECTORY_SEARCH
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CONNECTIVITY_USE_RESTRICTED_NETWORKS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.GRANT_WALLPAPER_PERMISSIONS
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.WRITE_USER_DICTIONARY
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.REGISTER_SIM_SUBSCRIPTION
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.eg.android.AlipayGphone.permission.MIPUSH_RECEIVE
    package:com.eg.android.AlipayGphone
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_SYNC_STATS
    package:android
    label:read sync statistics
    description:Allows an app to read the sync stats for an account, including the history of sync events and how much data is synced.
    protectionLevel:normal
  + permission:android.permission.WRITE_DREAM_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.FREEZE_SCREEN
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:broadcast.cne.permission
    package:com.quicinc.cne.CNEService
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.dialer.permission.C2D_MESSAGE
    package:com.google.android.dialer
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REBOOT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.DISPATCH_NFC_MESSAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.chimera.permission.CONFIG_CHANGE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.auth.permission.FACE_UNLOCK
    package:com.android.facelock
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MOUNT_FORMAT_FILESYSTEMS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.OEM_UNLOCK_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.REGISTER_CONNECTION_MANAGER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_DEVICE_ADMINS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CLEAR_APP_CACHE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CHANGE_APP_IDLE_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.auth.permission.GOOGLE_ACCOUNT_CHANGE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.trustagent.framework.model.DATA_ACCESS
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_TRUST_AGENT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_DOCUMENTS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.alibaba.android.rimet.permission.MIPUSH_RECEIVE
    package:com.alibaba.android.rimet
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_PDB_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_NETWORK_POLICY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_REMOTEVIEWS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.apps.gcs.permission.RECEIVE_NETWORK_SCORES
    package:com.google.android.apps.gcs
    label:receive network scores
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.docs.editors.trix.permission.WRITE_IMAGES
    package:com.google.android.apps.docs.editors.sheets
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ASEC_MOUNT_UNMOUNT
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GRANT_RUNTIME_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|installer|verifier
  + permission:android.permission.SET_POINTER_SPEED
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CHANGE_BACKGROUND_DATA_SETTING
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_NOTIFICATIONS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.systemui.permission.SELF
    package:com.android.systemui
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.chrome.TOS_ACKED
    package:com.android.chrome
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.GLOBAL_SEARCH
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.NET_TUNNELING
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CONNECTIVITY_INTERNAL
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.FACTORY_TEST
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SET_WALLPAPER_HINTS
    package:android
    label:adjust your wallpaper size
    description:Allows the app to set the system wallpaper size hints.
    protectionLevel:normal
  + permission:android.permission.MANAGE_MEDIA_PROJECTION
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_SYNC_SETTINGS
    package:android
    label:read sync settings
    description:Allows the app to read the sync settings for an account. For example, this can determine whether the People app is synced with an account.
    protectionLevel:normal
  + permission:com.google.android.gms.permission.SHOW_TRANSACTION_RECEIPT
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.now.CURRENT_ACCOUNT_ACCESS
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.partnersetup.permission.ACCESS_PROVIDER
    package:com.google.android.partnersetup
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.permission.ACCESS_CHECKIN
    package:com.motorola.motosignature.app
    label:permission to access the checkin provider
    description:Allows system apps to access the Checkin Provider.
    protectionLevel:signature|privileged
  + permission:com.android.browser.permission.WRITE_HISTORY_BOOKMARKS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:com.android.chrome.permission.C2D_MESSAGE
    package:com.android.chrome
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BROADCAST_PACKAGE_REMOVED
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.audiomonitor.permission.LOCAL
    package:com.motorola.triggerenroll
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.OVERRIDE_WIFI_CONFIG
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.FORCE_STOP_PACKAGES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MANAGE_CA_CERTIFICATES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CAPTURE_VIDEO_OUTPUT
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ACCESS_NOTIFICATIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.mm.plugin.permission.WRITE
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature
  + permission:org.videolan.vlc.permission.BIND_DATA_CONSUMER
    package:org.videolan.vlc
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.VIBRATE
    package:android
    label:control vibration
    description:Allows the app to control the vibrator.
    protectionLevel:normal
  + permission:com.android.certinstaller.INSTALL_AS_USER
    package:com.android.certinstaller
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gsf.permission.CONNECTION
    package:com.google.android.gsf
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_ACCESSIBILITY_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.permission.READ_NDEF
    package:com.motorola.motosignature.app
    label:Read Android Beam data
    description:Allows the app to read Android Beam data from another app
    protectionLevel:signature
  + permission:android.server.checkin.CHECKIN.permission.C2D_MESSAGE
    package:com.google.android.gsf
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MANAGE_ACTIVITY_STACKS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SEND_CALL_LOG_CHANGE
    package:com.android.providers.contacts
    label:Broadcast that a change happened to the call log.
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.HDMI_CEC
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_INPUT_METHOD
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.INVOKE_CARRIER_SETUP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CHANGE_DEVICE_IDLE_TEMP_WHITELIST
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.REMOVE_DRM_CERTIFICATES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.googleapps.permission.GOOGLE_MAIL_SWITCH
    package:com.google.android.gsf.login
    label:select Gmail or Google Mail branding
    description:Allows apps to switch the displayed name between "Gmail" and "Google Mail" branding.
    protectionLevel:signature
  + permission:android.permission.READ_USER_DICTIONARY
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.FILTER_EVENTS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.permission.SAFETY_NET
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.RECEIVE_EMERGENCY_BROADCAST
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.finsky.permission.GEARHEAD_SERVICE
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CREATE_USERS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.googlehelp.LAUNCH_SUPPORT_SCREENSHARE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MODIFY_NETWORK_ACCOUNTING
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.common.internal.SHARED_PREFERENCES_PERMISSION
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.tencent.wifisdk.permission.disconnect
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.CRYPT_KEEPER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.BIND_NFC_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.START_PRINT_SERVICE_CONFIG_ACTIVITY
    package:com.android.printspooler
    label:null
    description:null
    protectionLevel:signature
  + permission:cn.kuwo.player.permission.MIPUSH_RECEIVE
    package:cn.kuwo.player
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.voicemail.permission.WRITE_VOICEMAIL
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.permission.SHOW_WARM_WELCOME_TAPANDPAY_APP
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.GET_DETAILED_TASKS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.NOTIFY_PENDING_SYSTEM_UPDATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.DISPATCH_PROVISIONING_MESSAGE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.ALLOW_ANY_CODEC_FOR_PLAYBACK
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MODIFY_APPWIDGET_BIND_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.andorid.gms.chimera.permission.QUERY_MODULES
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_WIFI_STATE
    package:android
    label:view Wi-Fi connections
    description:Allows the app to view information about Wi-Fi networking, such as whether Wi-Fi is enabled and name of connected Wi-Fi devices.
    protectionLevel:normal
  + permission:com.google.android.apps.enterprise.dmagent.permission.C2D_MESSAGE
    package:com.google.android.apps.enterprise.dmagent
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.permission.BROADCAST_TO_GOOGLEHELP
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.audiomonitor.permission.BROADCAST_RECEIVER
    package:com.motorola.triggerenroll
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:cmb.pb.permission.MIPUSH_RECEIVE
    package:cmb.pb
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.weread.permission.MIPUSH_RECEIVE
    package:com.tencent.weread
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.permission.READ_VALUABLES_IMAGES
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.FORCE_BACK
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.chrome.permission.READ_WRITE_BOOKMARK_FOLDERS
    package:com.android.chrome
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.launcher.permission.RECEIVE_LAUNCH_BROADCASTS
    package:com.google.android.googlequicksearchbox
    label:null
    description:null
    protectionLevel:signature
  + permission:com.motorola.permission.RECEIVE_APP_DIRECTED_SMS
    package:com.motorola.appdirectedsmsproxy
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.CHANGE_WIMAX_STATE
    package:android
    label:change WiMAX state
    description:Allows the app to connect the phone to and disconnect the phone from WiMAX networks.
    protectionLevel:normal
  + permission:com.google.android.gms.auth.authzen.permission.KEY_REGISTRATION_FINISHED
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:cn.kuwo.player.signatureOrSystem
    package:cn.kuwo.player
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.CAMERA_DISABLE_TRANSMIT_LED
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.REQUEST_INSTALL_PACKAGES
    package:android
    label:request install packages
    description:Allows an application to request installation of packages.
    protectionLevel:normal
  + permission:android.permission.CONTROL_INCALL_EXPERIENCE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.MODIFY_PHONE_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gm.email.permission.GET_WIDGET_UPDATE
    package:com.google.android.gm
    label:Update widget
    description:Allows the app to receive notifications when the widget should be refreshed, including the account name and folder name.
    protectionLevel:signature
  + permission:android.permission.ACCESS_VR_MANAGER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gm.email.permission.UPDATE_AUTH_NOTIFICATION
    package:com.google.android.gm
    label:Update authentication notification
    description:Allows the app to display a notification when authentication fails.
    protectionLevel:signature
  + permission:com.google.android.googlequicksearchbox.LAUNCH_FROM_DSP_HOTWORD
    package:com.google.android.googlequicksearchbox
    label:Launch voice search from DSP hotword
    description:Launch voice search from DSP hotword
    protectionLevel:signature|privileged
  + permission:android.permission.PACKET_KEEPALIVE_OFFLOAD
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.launcher.permission.INSTALL_SHORTCUT
    package:android
    label:install shortcuts
    description:Allows an application to add Homescreen shortcuts without user intervention.
    protectionLevel:normal
  + permission:android.permission.BIND_TEXT_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.STATUS_BAR
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_FRAME_BUFFER
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.smartdevice.permission.broadcast
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.SEND_SMS_NO_CONFIRMATION
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.DRIVE
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.DUMP
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|development
  + permission:android.permission.GET_APP_GRANTED_URI_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.LOCATION_HARDWARE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.marvin.talkback.permission.LABELING
    package:com.google.android.marvin.talkback
    label:Manage TalkBack custom labels
    description:Permission to access, modify, and delete custom labels spoken by TalkBack.
    protectionLevel:signature
  + permission:com.google.android.googlequicksearchbox.LAUNCH_WITH_RECORDED_AUDIO
    package:com.google.android.googlequicksearchbox
    label:Launch voice with recorded audio
    description:Launch voice with recorded audio
    protectionLevel:signature|privileged
  + permission:com.tencent.photos.permission.DATA
    package:com.tencent.mobileqq
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.READ_SOCIAL_STREAM
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.WAKE_LOCK
    package:android
    label:prevent phone from sleeping
    description:Allows the app to prevent the phone from going to sleep.
    protectionLevel:normal
  + permission:android.permission.INJECT_EVENTS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.apps.docs.editors.kix.permission.WRITE_IMAGES
    package:com.google.android.apps.docs.editors.docs
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.BIND_CHOOSER_TARGET_SERVICE
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.UPDATE_APP_OPS_STATS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged|installer
  + permission:android.permission.ACCESS_EPHEMERAL_APPS
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.ACCESS_INPUT_FLINGER
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.OBSERVE_GRANT_REVOKE_PERMISSIONS
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.READ_OEM_UNLOCK_STATE
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.android.vending.billing.ADD_CREDIT_CARD
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.tencent.mm.ext.permission.READ
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.SET_SCREEN_COMPATIBILITY
    package:android
    label:null
    description:null
    protectionLevel:signature
  + permission:com.android.vending.billing.IN_APP_NOTIFY.permission.C2D_MESSAGE
    package:com.android.vending
    label:null
    description:null
    protectionLevel:signature
  + permission:android.permission.MEDIA_CONTENT_CONTROL
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:android.permission.DELETE_PACKAGES
    package:android
    label:null
    description:null
    protectionLevel:signature|privileged
  + permission:com.google.android.gms.magictether.permission.DISABLE_SOFT_AP
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.calendar.permission.READ_OOBE
    package:com.google.android.calendar
    label:null
    description:null
    protectionLevel:signature
  + permission:com.google.android.gms.chromesync.permission.METADATA_UPDATED
    package:com.google.android.gms
    label:null
    description:null
    protectionLevel:signature
