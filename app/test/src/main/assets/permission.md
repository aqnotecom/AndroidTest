
$ adb shell pm list permissions -g -f -u

Dangerous and Normal Permissions:

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
  + permission:android.permission.READ_PHONE_STATE
    package:android
    label:read phone status and identity
    description:Allows the app to access the phone features of the device. This permission allows the app to determine the phone number and device IDs, whether a call is active, and the remote number connected by a call.
    protectionLevel:dangerous
  + permission:android.permission.CALL_PHONE
    package:android
    label:directly call phone numbers
    description:Allows the app to call phone numbers without your intervention. This may result in unexpected charges or calls. Note that this doesn't allow the app to call emergency numbers. Malicious apps may cost you money by making calls without your confirmation.
    protectionLevel:dangerous
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
  + permission:android.permission.ACCESS_WIMAX_STATE
    package:android
    label:connect and disconnect from WiMAX
    description:Allows the app to determine whether WiMAX is enabled and information about any WiMAX networks that are connected.
    protectionLevel:normal
  + permission:android.permission.RESTART_PACKAGES
    package:android
    label:close other apps
    description:Allows the app to end background processes of other apps. This may cause other apps to stop running.
    protectionLevel:normal
  + permission:android.permission.USE_CREDENTIALS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.MODIFY_AUDIO_SETTINGS
    package:android
    label:change your audio settings
    description:Allows the app to modify global audio settings such as volume and which speaker is used for output.
    protectionLevel:normal
  + permission:android.permission.ACCESS_NOTIFICATION_POLICY
    package:android
    label:access Do Not Disturb
    description:Allows the app to read and write Do Not Disturb configuration.
    protectionLevel:normal
  + permission:android.permission.MANAGE_ACCOUNTS
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.NFC
    package:android
    label:control Near Field Communication
    description:Allows the app to communicate with Near Field Communication (NFC) tags, cards, and readers.
    protectionLevel:normal
  + permission:android.permission.CHANGE_NETWORK_STATE
    package:android
    label:change network connectivity
    description:Allows the app to change the state of network connectivity.
    protectionLevel:normal
  + permission:android.permission.PERSISTENT_ACTIVITY
    package:android
    label:make app always run
    description:Allows the app to make parts of itself persistent in memory. This can limit memory available to other apps slowing down the phone.
    protectionLevel:normal
  + permission:android.permission.WRITE_SYNC_SETTINGS
    package:android
    label:toggle sync on and off
    description:Allows an app to modify the sync settings for an account. For example, this can be used to enable sync of the People app with an account.
    protectionLevel:normal
  + permission:android.permission.RECEIVE_BOOT_COMPLETED
    package:android
    label:run at startup
    description:Allows the app to have itself started as soon as the system has finished booting. This can make it take longer to start the phone and allow the app to slow down the overall phone by always running.
    protectionLevel:normal
  + permission:android.permission.SUBSCRIBED_FEEDS_READ
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.SET_TIME_ZONE
    package:android
    label:set time zone
    description:Allows the app to change the phone's time zone.
    protectionLevel:normal
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
  + permission:android.permission.BLUETOOTH
    package:android
    label:pair with Bluetooth devices
    description:Allows the app to view the configuration of the Bluetooth on the phone, and to make and accept connections with paired devices.
    protectionLevel:normal
  + permission:android.permission.CHANGE_WIFI_MULTICAST_STATE
    package:android
    label:allow Wi-Fi Multicast reception
    description:Allows the app to receive packets sent to all devices on a Wi-Fi network using multicast addresses, not just your phone. It uses more power than the non-multicast mode.
    protectionLevel:normal
  + permission:com.android.alarm.permission.SET_ALARM
    package:android
    label:set an alarm
    description:Allows the app to set an alarm in an installed alarm clock app. Some alarm clock apps may not implement this feature.
    protectionLevel:normal
  + permission:com.google.android.gms.permission.AD_ID_NOTIFICATION
    package:com.google.android.gms
    label:Advertising ID notification
    description:Allow an app to receive a notification when the advertising ID or limit ad tracking preference of the user is updated.
    protectionLevel:normal
  + permission:android.permission.GET_TASKS
    package:android
    label:retrieve running apps
    description:Allows the app to retrieve information about currently and recently running tasks. This may allow the app to discover information about which applications are used on the device.
    protectionLevel:normal
  + permission:android.permission.SUBSCRIBED_FEEDS_WRITE
    package:android
    label:null
    description:null
    protectionLevel:normal
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
  + permission:android.permission.TRANSMIT_IR
    package:android
    label:transmit infrared
    description:Allows the app to use the phone's infrared transmitter.
    protectionLevel:normal
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
  + permission:android.permission.BLUETOOTH_ADMIN
    package:android
    label:access Bluetooth settings
    description:Allows the app to configure the local Bluetooth phone, and to discover and pair with remote devices.
    protectionLevel:normal
  + permission:android.permission.WRITE_SOCIAL_STREAM
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.GET_PACKAGE_SIZE
    package:android
    label:measure app storage space
    description:Allows the app to retrieve its code, data, and cache sizes
    protectionLevel:normal
  + permission:android.permission.WRITE_PROFILE
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:com.tencent.mm.ext.permission.SPORT
    package:com.tencent.mm
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.ACCESS_LOCATION_EXTRA_COMMANDS
    package:android
    label:access extra location provider commands
    description:Allows the app to access extra location provider commands. This may allow the app to interfere with the operation of the GPS or other location sources.
    protectionLevel:normal
  + permission:android.permission.BROADCAST_STICKY
    package:android
    label:send sticky broadcast
    description:Allows the app to send sticky broadcasts, which remain after the broadcast ends. Excessive use may make the phone slow or unstable by causing it to use too much memory.
    protectionLevel:normal
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
  + permission:android.permission.CHANGE_WIFI_STATE
    package:android
    label:connect and disconnect from Wi-Fi
    description:Allows the app to connect to and disconnect from Wi-Fi access points and to make changes to device configuration for Wi-Fi networks.
    protectionLevel:normal
  + permission:android.permission.READ_INSTALL_SESSIONS
    package:android
    label:read install sessions
    description:Allows an application to read install sessions. This allows it to see details about active package installations.
    protectionLevel:normal
  + permission:android.permission.FLASHLIGHT
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.ACCESS_NETWORK_STATE
    package:android
    label:view network connections
    description:Allows the app to view information about network connections such as which networks exist and are connected.
    protectionLevel:normal
  + permission:android.permission.DISABLE_KEYGUARD
    package:android
    label:disable your screen lock
    description:Allows the app to disable the keylock and any associated password security. For example, the phone disables the keylock when receiving an incoming phone call, then re-enables the keylock when the call is finished.
    protectionLevel:normal
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
  + permission:android.permission.KILL_BACKGROUND_PROCESSES
    package:android
    label:close other apps
    description:Allows the app to end background processes of other apps. This may cause other apps to stop running.
    protectionLevel:normal
  + permission:android.permission.WRITE_USER_DICTIONARY
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.READ_SYNC_STATS
    package:android
    label:read sync statistics
    description:Allows an app to read the sync stats for an account, including the history of sync events and how much data is synced.
    protectionLevel:normal
  + permission:android.permission.SET_WALLPAPER_HINTS
    package:android
    label:adjust your wallpaper size
    description:Allows the app to set the system wallpaper size hints.
    protectionLevel:normal
  + permission:android.permission.READ_SYNC_SETTINGS
    package:android
    label:read sync settings
    description:Allows the app to read the sync settings for an account. For example, this can determine whether the People app is synced with an account.
    protectionLevel:normal
  + permission:com.android.browser.permission.WRITE_HISTORY_BOOKMARKS
    package:android
    label:null
    description:null
    protectionLevel:normal
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
  + permission:android.permission.READ_USER_DICTIONARY
    package:android
    label:null
    description:null
    protectionLevel:normal
  + permission:android.permission.ACCESS_WIFI_STATE
    package:android
    label:view Wi-Fi connections
    description:Allows the app to view information about Wi-Fi networking, such as whether Wi-Fi is enabled and name of connected Wi-Fi devices.
    protectionLevel:normal
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
  + permission:android.permission.REQUEST_INSTALL_PACKAGES
    package:android
    label:request install packages
    description:Allows an application to request installation of packages.
    protectionLevel:normal
  + permission:com.android.launcher.permission.INSTALL_SHORTCUT
    package:android
    label:install shortcuts
    description:Allows an application to add Homescreen shortcuts without user intervention.
    protectionLevel:normal
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
