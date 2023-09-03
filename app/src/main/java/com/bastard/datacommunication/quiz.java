package com.bastard.datacommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class quiz extends AppCompatActivity {

	private TextView questionTextView;
	private static final long COUNTDOWN_IN_MILLIS = 40000;
	private TextView scores;
	private int totalCorrect = 0;
	private RadioGroup answerRadioGroup;
	private final int currentQuestion = 0;
	private Button nextButton;
	private TextView resultTextView;
	private CountDownTimer countDownTimer;
	private long timeLeftInMillis;
	private TextView textViewCountDOwn;
	private CheckBox chkAnswer;

	private ColorStateList textColorDefaultCd;

	private final String[] questions = {
			"1. Which of the following is NOT an advantage of using SSDs over HDDs?",
			"2. What type of cable is commonly used to connect a printer to a computer?",
			"3. Which of the following ports is typically used for HTTP traffic?",
			"4. What is the primary purpose of the BIOS?",
			"5. Which RAID level provides redundancy without striping?",
			"6. Which wireless standard operates at 5 GHz frequency?",
			"7. What is the maximum data transfer rate for USB 3.0?",
			"8. What is the main function of a CPU?",
			"9. What is the typical subnet mask for a Class C IP address?",
			"10. Which of the following is the correct IPv6 address format?",
			"11. What type of RAM is commonly used in laptops?",
			"12. What is the primary function of a network switch?",
			"13. Which of the following is a common type of power supply found in desktop computers?",
			"14. Which Windows utility is used to manage startup applications?",
			"15. Which of the following tools is used to test network connectivity and latency?",
			"16. What is the maximum cable length for a Cat6 Ethernet cable?",
			"17. What type of connector is commonly used for fiber optic cables?",
			"18. Which device is used to amplify a network signal?",
			"19. Which type of virtualization allows multiple operating systems to run simultaneously on a single physical machine?",
			"20. What is the purpose of a POST test?",
			"21. What type of malware is designed to replicate and spread across networks?",
			"22. Which of the following is a type of biometric authentication?",
			"23. What is the maximum resolution supported by the HDMI 1.4 standard?",
			"24. Which component is responsible for providing power to the CPU?",
			"25. What type of connector is used by SATA devices?",
			"26. Which of the following is NOT a type of RAM?",
			"27. What type of connector is commonly used to connect an external hard drive to a computer?",
			"28. Which protocol is used to automatically assign IP addresses to devices on a network?",
			"29. Which of the following is a type of computer cooling solution?",
			"30. Which of the following is a characteristic of a full-duplex communication?",
			"31. In a computer, where are the BIOS settings stored?",
			"32. Which of the following wireless standards uses MIMO technology?",
			"33. Which of the following is a common use of a KVM switch?",
			"34. What is the primary purpose of a firewall?",
			"35. Which of the following is an example of an input device?",
			"36. What is the default port number for HTTPS traffic?",
			"37. What type of memory is used by a CPU for high-speed temporary storage?",
			"38. Which of the following network devices works at the Data Link layer (Layer 2) of the OSI model?",
			"39. Which of the following cable types is typically used to connect a monitor to a computer?",
			"40. What is the maximum number of devices that can be connected to a single USB controller?",
			"41. What is the purpose of a heat spreader on a CPU?",
			"42. Which of the following is a common type of power connector for a motherboard?",
			"43. What type of battery is typically used to power a computer's real-time clock (RTC)?",
			"44. What is the maximum cable length for a USB 2.0 device?",
			"45. Which of the following wireless encryption standards is considered the most secure?",
			"46. Which of the following file systems is commonly used by Windows operating systems?",
			"47. What is the purpose of an uninterruptible power supply (UPS)?",
			"48. Which of the following is a valid IPv4 address?",
			"49. What is the purpose of a DMZ in a network?",
			"50. Which of the following is a characteristic of an ad hoc wireless network?",
			"51. What type of RAM is specifically designed for use in graphics cards?",
			"52. Which of the following is an advantage of a hardware RAID over a software RAID?",
			"53. Which of the following topologies is most commonly used in Ethernet networks?",
			"54. What type of software is typically used to manage virtual machines?",
			"55. Which of the following commands is used to display the IP configuration of a Windows computer?",
			"56. Which of the following is a common purpose of a proxy server?",
			"57. Which of the following connectors is commonly used for analog audio?",
			"58. What is the purpose of a computer's Northbridge?",
			"59. Which of the following is an example of an output device?",
			"60. What type of malware typically disguises itself as legitimate software?",
			"61. Which of the following network devices is used to connect multiple networks together?",
			"62. What type of cable is commonly used for high-speed internet connections?",
			"63. What is the default port number for SMTP traffic?",
			"64. What type of connector is commonly used for internal hard drives in desktop computers?",
			"65. Which of the following devices uses flash memory for storage?",
			"66. What type of cooling solution uses a liquid coolant to transfer heat away from components?",
			"67. What is the purpose of a NIC (Network Interface Card) in a computer?",
			"68. Which of the following is an example of a network protocol?",
			"69. Which type of printer uses heat to transfer ink onto paper?",
			"70. What type of connector is commonly used for a computer keyboard?",
			"71. Which of the following is a type of non-volatile memory?",
			"72. Which of the following is a common use for a VLAN?",
			"73. Which of the following is an example of a Layer 3 network device?",
			"74. What is the purpose of a DNS server?",
			"75. Which of the following is an advantage of using an SSD over an HDD?",
			"76. Which of the following is a common RAID level that provides disk mirroring?",
			"77. What type of cable is commonly used to connect a computer to a router or switch?",
			"78. Which of the following is the standard for wireless communication between devices over short distances?",
			"79. Which of the following wireless technologies is typically used for contactless payment systems?",
			"80. What is the maximum cable length for a CAT6 Ethernet cable?",
			"81. What type of port is commonly used to connect a mouse to a computer?",
			"82. Which of the following is a common type of memory card used in digital cameras?",
			"83. Which type of malware is specifically designed to encrypt files and demand a ransom for their release?",
			"84. Which of the following network topologies is most vulnerable to a single point of failure?",
			"85. What is the purpose of port forwarding on a router?",
			"86. Which of the following is a common way to secure a wireless network?",
			"87. What type of connector is commonly used for video on a desktop computer monitor?",
			"88. Which of the following is the primary function of a CPU?",
			"89. What is the maximum speed supported by the USB 3.0 standard?",
			"90. Which of the following is an example of a cloud-based service?",
			"91. Which of the following is a type of backup that only copies files that have changed since the last full backup?",
			"92. What type of network device is used to extend the range of a wireless network?",
			"93. Which of the following is an example of a physical security measure for a computer?",
			"94. What is the maximum cable length for a CAT5e Ethernet cable?",
			"95. Which of the following devices provides centralized storage for a network?",
			"96. What is the primary function of a computer's Southbridge chip?",
			"97. Which of the following is a common way to reset a forgotten BIOS password?",
			"98. What type of connector is commonly used for headphones?",
			"99. Which of the following is a benefit of virtualization?",
			"100. Which of the following is a common use of a loopback IP address?",
			"101. What is the purpose of a heatsink in a computer?",
			"102. Which of the following is a type of computer storage that uses magnetic disks to store data?",
			"103. Which of the following is a common connector used for fiber optic cables?",
			"104. Which of the following is an example of a Layer 2 network device?",
			"105. Which of the following network devices is used to amplify a signal in a wired network?",
			"106. What type of connector is commonly used for a TV's coaxial cable input?",
			"107. Which of the following is a characteristic of an IPv6 address?",
			"108. What is the default port number for HTTPS traffic?",
			"109. What type of computer memory is used to store the BIOS settings when a computer is powered off?",
			"110. Which of the following is a common method for securing a wireless network?",
			"111. What type of connector is commonly used for a computer's power supply?",
			"112. Which of the following is a characteristic of a half-duplex communication?",
			"113. Which of the following is a common function of a firewall?",
			"114. What is the maximum data transfer rate of a CAT5e Ethernet cable?",
			"115. What type of connector is commonly used for the internal power supply of a SATA hard drive?",
			"116. Which of the following is an example of a network topology?",
			"117. Which of the following is an example of a cloud-based service?",
			"118. What is the purpose of a KVM switch?",
			"119. Which of the following is a common symptom of a failing power supply unit (PSU)?",
			"120. Which of the following is a type of removable storage media?",
			"121. What type of network cable is used to connect two devices of the same type directly?",
			"122. Which of the following is an example of a peripheral device?",
			"123. Which of the following is an example of a network protocol?",
			"124. What type of computer memory is volatile and loses its contents when the power is turned off?",
			"125. Which of the following is an advantage of using a solid-state drive (SSD) over a hard disk drive (HDD)?",
			"126. What type of malware is self-replicating and spreads through a network without user intervention?",
			"127. Which of the following is a common way to increase the range of a wireless network?",
			"128. Which of the following is an example of a network operating system?",
			"129. What type of connector is commonly used for analog audio on a stereo system?",
			"130. Which of the following is a common method to troubleshoot a computer that is not POSTing?",
			"131. Which of the following is a common type of authentication?",
			"132. What is the purpose of a UPS (Uninterruptible Power Supply)?",
			"133. Which of the following is a common symptom of a failing hard drive?",
			"134. Which of the following is a type of optical disc?",
			"135. What is the maximum speed supported by the USB 2.0 standard?",
			"136. What is the primary function of a network switch?",
			"137. Which of the following is a type of computer storage that uses integrated circuits to store data?",
			"138. Which of the following is a common method for securing a wireless network?",
			"139. What is the primary function of a computer's Northbridge chip?",
			"140. What type of connector is commonly used for an external hard drive?",
			"141. Which of the following is a type of backup that copies all selected files, regardless of whether they have been modified since the last backup?",
			"142. What type of network device is used to connect two different networks together?",
			"143. What is the maximum cable length for a CAT6a Ethernet cable?",
			"144. What is the maximum data transfer rate of a CAT6 Ethernet cable?",
			"145. What type of connector is commonly used for a computer's Ethernet port?",
			"146. What type of cable is commonly used to connect a monitor to a computer's video card?",
			"147. Which of the following is a common reason for a computer to overheat?",
			"148. Which of the following is an example of an output device?",
			"149. What is the purpose of a RAID (Redundant Array of Independent Disks) configuration?",
			"150. Which of the following is a common reason for a No Boot Device Found error message?",
			"151. Which of the following is a common type of network architecture?",
			"152. What type of software is used to manage and control the hardware and basic system operations of a computer?",
			"153. Which of the following is a characteristic of an IPv4 address?",
			"154. What type of RAM is commonly used in laptops?",
			"155. Which of the following is a common type of Virtual Private Network (VPN) protocol?",
			"156. What is the default port number for FTP data transfer?",
			"157. Which of the following is a type of computer storage that uses laser beams to read and write data?",
			"158. What type of cable is commonly used for telephone line connections?",
			"159. Which of the following is a common function of a proxy server?",
			"160. What type of connector is commonly used for a computer's serial port?",
			"161. Which of the following is an example of a network medium?",
			"162. Which of the following is an example of a Layer 3 network device?",
			"163. What type of connector is commonly used for a computer's parallel port?",
			"164. What is the maximum data transfer rate of a USB 3.0 connection?",
			"165. Which of the following is a common method for troubleshooting a malfunctioning device driver?",
			"166. What is the primary function of a network hub?",
			"167. Which of the following is a type of computer storage that uses flash memory to store data?",
			"168. Which of the following is a common method for securing a wired network?",
			"169. What is the primary function of a computer's BIOS?",
			"170. What type of connector is commonly used for a computer's USB port?",
			"171. Which of the following is a type of backup that only copies files that have been modified since the last full backup?",
			"172. What type of network device is used to connect multiple devices to a single network?",
			"173. What is the maximum cable length for a CAT5e Ethernet cable?",
			"174. What is the maximum data transfer rate of a CAT7 Ethernet cable?",
			"175. What type of connector is commonly used for a computer's VGA port?",
			"176. Which of the following is a type of computer storage that uses magnetic disks to store data?",
			"177. Which of the following is a common method for reducing the risk of a computer virus infection?",
			"178. What is the primary function of a computer's Southbridge chip?",
			"179. Which of the following is an example of an input device?",
			"180. What type of encryption is commonly used to secure Wi-Fi networks?",
			"181. What type of connector is commonly used for a computer's PS/2 port?",
			"182. What is the primary purpose of a computer's CPU?",
			"183. What type of connector is commonly used for a computer's power supply?",
			"184. Which of the following is a type of computer storage that uses spinning disks and read/write heads to store data?",
			"185. What is the maximum data transfer rate of a USB 3.1 connection?",
			"186. Which of the following is a type of computer storage that uses semiconductor memory to store data?",
			"187. Which of the following is an example of an open-source operating system?",
			"188. What type of connector is commonly used for a computer's audio ports?",
			"189. What type of connector is commonly used for a computer's Ethernet port?",
			"190. What is the maximum data transfer rate of a USB 3.2 connection?",
			"191. What is the default port number for HTTP?",
			"192. Which of the following is an example of a network topology?",
			"193. What type of software is used to run specific tasks or applications on a computer?",
			"194. Which of the following is a characteristic of an IPv6 address?",
			"195. What type of RAM is commonly used in desktop computers?",
			"196. Which of the following is a common type of Virtual Private Network (VPN) protocol?",
			"197. What is the default port number for SMTP?",
			"198. Which of the following is a type of computer storage that uses solid-state memory to store data?",
			"199. What is the maximum cable length for a CAT5 Ethernet cable?",
			"200. Which of the following is a common method for troubleshooting a malfunctioning computer component?"

	};

	private final String[][] answers = {
			{"Lower power consumption", "Faster read and write speeds", "Lower cost", "Less noise"},
			{"RJ-11", "USB", "HDMI", "RG-6"},
			{"21", "25", "80", "110"},
			{"Store temporary data", "Handle file management", "Initialize and test hardware components", "Install the operating system"},
			{"RAID 0", "RAID 1", "RAID 5", "RAID 6"},
			{"802.11a", "802.11b", "802.11g", "802.11n"},
			{"480 Mbps", "5 Gbps", "10 Gbps", "40 Gbps"},
			{"Manage system resources",	"Provide storage", "Execute instructions", "Regulate power supply"},
			{"255.0.0.0","255.255.0.0", "255.255.255.0", "255.255.255.255"},
			{"2001:0db8:85a3:0000:0000:8a2e:0370:7334", "192.168.1.1", "255.255.255.0", "172.16.0.0/12"},
			{"DIMM", "SO-DIMM", "SIMM", "RIMM"},
			{"Act as a traffic cop for network traffic", "Convert data into radio signals", "Provide a connection point for network devices", "Store and forward data packets"},
			{"ATX", "Micro-ATX", "Mini-ITX", "Pico-ATX"},
			{"Control Panel", "Task Manager", "Services", "System Configuration"},
			{"ipconfig", "ping", "nslookup", "tracert"},
			{"50 meters", "100 meters", "200 meters", "500 meters"},
			{"BNC", "RJ-45", "LC", "F-connector"},
			{"Hub", "Repeater", "Switch", "Router"},
			{"Application virtualization", "Network virtualization", "Storage virtualization", "Hardware virtualization"},
			{"To install software updates", "To diagnose hardware issues", "To initialize hardware components", "To configure network settings"},
			{"Trojan", "Virus", "Worm", "Ransomware"},
			{"Password", "Token", "Fingerprint scan", "Smart card"},
			{"1080p", "4K", "5K", "8K"},
			{"Power supply", "VRM (Voltage Regulator Module)", "CMOS battery", "Capacitor"},
			{"7-pin", "15-pin", "24-pin", "40-pin"},
			{"DDR", "SDRAM", "AGP", "GDDR"},
			{"eSATA", "VGA", "DVI", "RCA"},
			{"DNS", "DHCP", "SNMP", "RDP"},
			{"Heat sink", "Power supply", "Capacitor", "Transistor"},{"Data can be transmitted in one direction at a time", "Data can be transmitted in both directions at the same time", "Data can be transmitted in both directions, but not at the same time", "Data can be transmitted in one direction only"},
			{"RAM", "ROM", "CMOS", "CPU"}, {"802.11a", "802.11b", "802.11g", "802.11n"},
			{"Network traffic management", "Sharing peripherals between computers", "Power management for multiple devices", "Data storage and retrieval"},
			{"Virus scanning", "Data backup", "Network security", "Password management"},
			{"Monitor", "Printer", "Keyboard", "Speaker"},{"21", "80","443", "8080"},
			{"RAM", "ROM", "Cache", "EEPROM"},
			{"Hub", "Switch", "Router", "Firewall"}, {"Coaxial", "Twisted pair", "HDMI", "Fiber optic"},
			{"8", "16", "64", "127"},
			{"Increase clock speed", "Prevent electrical shorts", "Distribute heat evenly", "Store data"},
			{"4-pin Molex", "6-pin PCIe", "20+4-pin ATX", "15-pin SATA"},
			{"NiMH", "Li-ion", "Li-poly", "Button cell"},{"3 meters", "5 meters", "10 meters", "15 meters"},
			{"WEP", "WPA", "WPA2", "WPA3"}, {"FAT32", "NTFS", "ext4", "HFS+"},
			{"To provide additional power outlets", "To filter power line noise", "To provide temporary power during a power outage", "To improve power efficiency"},
			{"256.168.1.1", "192.168.1.1", "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "172.16.0.0/12"},
			{"To provide a secure area for internal file storage", "To isolate systems with sensitive data", "To provide a buffer zone between the internal network and the internet", "To distribute network traffic evenly"},
			{"It uses a central access point", "It is a peer-to-peer network", "It requires a wired connection", "It uses a network switch"},
			{"SDRAM", "DDR", "GDDR", "HBM"},
			{"Lower cost", "Easier to set up", "Better performance", "Requires less system resources"},
			{"Bus", "Star", "Ring", "Mesh"},{"Hypervisor", "BIOS", "Operating system", "Device driver"},
			{"ipconfig", "ifconfig", "netstat", "nslookup"},
			{"Load balancing", "File storage", "Network security", "Content filtering"},
			{"TRS (Tip, Ring, Sleeve)", "RCA", "HDMI", "DisplayPort"},
			{"To manage power supply", "To facilitate communication between the CPU and memory", "To manage input/output devices", "To store BIOS settings"},
			{"Scanner", "Microphone", "Mouse", "Projector"}, {"Trojan", "Virus", "Worm", "Spyware"},
			{"Switch", "Router", "Hub", "Repeater"}, {"Twisted pair", "Coaxial", "Fiber optic", "Ribbon"},
			{"21", "25", "80", "110"}, {"SATA", "PATA", "SAS", "IDE"}, {"Hard disk drive", "CD-ROM", "DVD", "USB flash drive"},
			{"Air cooling", "Liquid cooling", "Passive cooling", "Active cooling"},
			{"To provide a connection to a network", "To manage power supply", "To process graphics", "To store data"},
			{"SMTP", "USB", "SATA", "HDMI"}, {"Inkjet", "Laser", "Thermal", "Dot matrix"},
			{"PS/2", "USB", "RJ-45", "VGA"}, {"RAM", "Cache", "ROM", "SRAM"},
			{"Network segmentation", "Load balancing", "Power management", "File storage"},
			{"Hub", "Switch", "Router", "Modem"},
			{"To provide network security", "To resolve hostnames to IP addresses", "To assign IP addresses to devices", "To manage network traffic"},
			{"Higher storage capacity", "Longer lifespan", "Faster data access", "Lower price"},
			{"RAID 0", "RAID 1", "RAID 5", "RAID 10"},{"Coaxial", "Fiber optic", "Twisted pair", "HDMI"},
			{"Wi-Fi", "Bluetooth", "NFC", "Infrared"}, {"Wi-Fi", "Bluetooth", "NFC", "Infrared"},
			{"55 meters", "100 meters", "200 meters", "300 meters"},
			{"PS/2", "USB", "RJ-45", "DVI"}, {"CompactFlash", "MMC", "SD", "xD-Picture Card"},
			{"Worm", "Trojan", "Spyware", "Ransomware"},{"Bus", "Star", "Ring", "Mesh"},
			{"To block specific ports for security reasons", "To redirect incoming network traffic to a specific device or service", "To manage network traffic between different networks", "To optimize the performance of a network"},
			{"Disable SSID broadcast", "Enable MAC address filtering", "Enable WPA3 encryption", "Enable SNMP"},
			{"BNC", "RCA", "HDMI", "VGA"}, {"Process data and execute instructions", "Store data and files", "Manage input/output devices", "Provide power to the computer"},
			{"12 Mbps", "480 Mbps", "5 Gbps", "10 Gbps"}, {"Google Drive", "Microsoft Office", "Adobe Photoshop", "Mozilla Firefox"},
			{"Incremental backup", "Differential backup", "Full backup", "Partial backup"},
			{"Hub", "Switch", "Router", "Wireless repeater"}, {"Firewall", "Antivirus software", "Cable lock", "User authentication"},
			{"55 meters", "100 meters", "200 meters", "300 meters"}, {"Router", "Switch", "Network-attached storage (NAS)", "Wireless access point"},
			{"To manage power supply", "To facilitate communication between the CPU and memory", "To manage input/output devices", "To store BIOS settings"},
			{"Enter a default password", "Remove the CMOS battery", "Reinstall the operating system", "Replace the BIOS chip"},
			{"TRS (Tip, Ring, Sleeve)", "RCA", "HDMI", "DisplayPort"}, {"Lower hardware costs", "Increased power consumption", "Decreased network performance", "Easier physical maintenance"},
			{"To test network connectivity", "To assign IP addresses to devices", "To resolve hostnames to IP addresses", "To provide a connection to a network"},
			{"To provide power to the components", "To dissipate heat generated by components", "To store data and files", "To manage input/output devices"},{"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"ST", "SC", "LC", "All of the above"}, {"Hub", "Switch", "Router", "Firewall"},{"Repeater", "Bridge", "Router", "Switch"},
			{"F-type", "BNC", "RCA", "HDMI"}, {"32-bit address", "64-bit address", "128-bit address", "256-bit address"},
			{"80", "110", "443", "8080"}, {"RAM", "Cache", "ROM", "CMOS"},{"Disable DHCP", "Disable ICMP", "Enable WPA2 encryption", "Enable port forwarding"},
			{"Molex", "SATA", "PATA", "ATX"}, {"Data can be transmitted and received simultaneously", "Data can only be transmitted or received at any given time", "Data is transmitted in one direction only", "Data is transmitted in multiple directions simultaneously"},
			{"Load balancing", "Content filtering", "Packet filtering", "File storage"},
			{"10 Mbps", "100 Mbps", "1 Gbps", "10 Gbps"}, {"Molex", "SATA power", "PATA power", "ATX power"},
			{"Bus", "Router", "Hub", "Repeater"}, {"Microsoft OneDrive", "Microsoft Word", "Adobe Illustrator", "Mozilla Firefox"},
			{"To extend the range of a wireless network", "To allow multiple computers to share a single keyboard, video display, and mouse", "To manage power distribution to multiple devices", "To route network traffic between different networks"},
			{"Random system reboots", "Unresponsive keyboard or mouse", "Distorted display", "Slow network connection"},
			{"Hard disk drive", "SSD", "Blu-ray disc", "RAM"}, {"Straight-through cable", "Crossover cable", "Rollover cable", "Patch cable"},
			{"CPU", "RAM", "Hard drive", "Printer"}, {"FTP", "USB", "SATA", "DVI"}, {"RAM", "Cache", "ROM", "CMOS"}, {"Higher storage capacity", "Longer lifespan", "Faster data access", "Lower price"},
			{"Virus", "Worm", "Trojan", "Spyware"}, {"Enable SSID broadcast", "Enable MAC address filtering", "Disable WPA encryption", "Install a wireless range extender"},
			{"Windows Server", "Linux", "macOS", "All of the above"}, {"TRS (Tip, Ring, Sleeve)", "RCA", "HDMI", "DisplayPort"},
			{"Run a system restore", "Reinstall the operating system", "Remove and reseat the RAM", "Replace the hard drive"},
			{"Something you know (e.g., password)", "Something you have (e.g., smart card)", "Something you are (e.g., fingerprint)", "All of the above"},
			{"To provide backup power during a power outage", "To increase the range of a wireless network", "To provide power to a computer's components", "To manage input/output devices"},
			{"CD-ROM", "DVD-ROM", "Blu-ray", "All of the above"}, {"1.5 Mbps", "12 Mbps", "480 Mbps", "5 Gbps"}, {"o amplify network signals", "To extend the range of a wireless network", "To route network traffic between different networks", "To forward data packets to their intended destinations"},
			{"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"}, {"Enable SSID broadcast", "Enable MAC address filtering", "Disable WPA encryption", "Disable port forwarding"},
			{"To manage power supply", "To facilitate communication between the CPU and memory", "To manage input/output devices", "To store BIOS settings"},
			{"eSATA", "USB", "FireWire", "All of the above"}, {"Incremental backup", "Differential backup", "Full backup", "Partial backup"}, {"Hub", "Bridge", "Router", "Wireless repeater"},
			{"55 meters", "100 meters", "200 meters", "300 meters"}, {"100 Mbps", "1 Gbps", "5 Gbps", "10 Gbps"}, {"RJ-11", "RJ-45", "USB", "HDMI"},
			{"VGA", "DVI", "HDMI", "All of the above"}, {"Excessive dust buildup", "Unresponsive keyboard or mouse", "Slow network connection", "Distorted display"},
			{"Keyboard", "Mouse", "Monitor", "Microphone"}, {"To increase storage capacity", "To improve data redundancy and fault tolerance", "To optimize power consumption", "To manage input/output devices"},
			{"Incorrect boot order in BIOS", "Corrupted operating system files", "Failing hard drive", "All of the above"}, {"Client-server", "Peer-to-peer", "Star", "Bus"},
			{"Operating system", "Application software", "Firmware", "Middleware"}, {"32-bit address", "64-bit address", "128-bit address", "256-bit address"}, {"DIMM", "SODIMM", "SRAM", "DRAM"},
			{"PPTP", "L2TP", "SSTP", "All of the above"}, {"20", "21", "22", "23"}, {"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"Coaxial cable", "Twisted pair cable", "Fiber optic cable", "Ribbon cable"}, {"Load balancing", "Content filtering", "Packet filtering", "File storage"},
			{"DB-9", "DB-15", "DB-25", "DB-37"}, {"Copper", "Fiber optic", "Radio waves", "All of the above"}, {"Hub", "Switch", "Router", "Firewall"}, {"DB-9", "DB-15", "DB-25", "DB-37"},
			{"480 Mbps", "1 Gbps", "5 Gbps", "10 Gbps"},{"Update the driver", "Roll back the driver", "Reinstall the driver", "All of the above"},
			{"To amplify network signals", "To extend the range of a wireless network", "To route network traffic between different networks", "To forward data packets to all connected devices"},
			{"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"}, {"Enable SSID broadcast", "Enable MAC address filtering", "Disable WPA encryption", "Disable port forwarding"},
			{"To manage power supply", "To facilitate communication between the CPU and memory", "To manage input/output devices", "To initialize hardware during the boot process"},
			{"USB Type-A", "USB Type-B", "USB Type-C", "All of the above"}, {"Incremental backup", "Differential backup", "Full backup", "Partial backup"},
			{"Hub", "Bridge", "Router", "Wireless repeater"}, {"55 meters", "100 meters", "200 meters", "300 meters"},{"10 Gbps", "25 Gbps", "40 Gbps", "100 Gbps"},
			{"DB-9", "DB-15", "DB-25", "DB-37"}, {"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"Installing antivirus software", "Enabling automatic updates", "Regularly backing up data", "All of the above"},
			{"To manage power supply", "To facilitate communication between the CPU and memory", "To manage input/output devices", "To store BIOS settings"},
			{"Keyboard", "Mouse", "Monitor", "Printer"}, {"WEP", "WPA", "WPA2", "All of the above"}, {"DIN-5", "Mini-DIN-6", "RJ-45", "USB Type-A"},
			{"To manage power supply", "To perform calculations and execute instructions", "To manage input/output devices", "To store BIOS settings"},
			{"IEC 60320 C13", "IEC 60320 C14", "IEC 60320 C15", "IEC 60320 C16"}, {"A. Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"5 Gbps", "10 Gbps", "20 Gbps", "40 Gbps"}, {"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"Windows", "macOS", "Linux", "Chrome OS"}, {"RCA", "TRS", "HDMI", "DisplayPort"}, {"RJ-11", "RJ-45", "USB", "HDMI"},
			{"10 Gbps", "20 Gbps", "40 Gbps", "100 Gbps"}, {"21", "25", "80", "443"}, {"Client-server", "Peer-to-peer", "Star", "Bus"},
			{"Operating system", "Application software", "Firmware", "Middleware"}, {"32-bit address", "64-bit address", "128-bit address", "256-bit address"},
			{"DIMM", "SODIMM", "SRAM", "DRAM"}, {"PPTP", "L2TP", "IKEv2", "All of the above"}, {"21", "25", "80", "443"}, {"Solid-state drive", "Hard disk drive", "Optical drive", "Flash drive"},
			{"55 meters", "100 meters", "200 meters", "300 meters"},
			{"Reseating the component", "Reinstalling the operating system", "Reinstalling the driver", "All of the above"}

	};

	private int currentQuestionIndex = 0;
	private final int[] correctAnswers = {2, 1, 2, 2, 1, 0, 1, 2, 2, 0, 1, 2, 0, 1, 1, 1, 2, 1, 3, 2, 2, 2, 1, 1, 0,2, 0, 1, 0, 1, 2, 3, 1, 2, 2, 2, 2, 1, 2, 3, 2, 2, 3, 1, 3, 1,2, 1, 2, 1,2, 2, 1 , 0, 0, 3, 0, 1, 3, 0, 1, 1, 1, 0, 3, 1, 0, 0, 2, 0, 2, 0, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 3, 0, 1, 2, 3, 0, 2, 0, 0, 3, 2, 1, 2,2, 1, 0, 0, 0 , 1,1,3,1,0,0,2,2,3,2,3,1,2,2,1,0,0,1,0,2,1,3,0,0,2,1,3,3,1,2,3,0,0,3,2,3,0,1,1,3,2,2,1,3,1,3,0,2,1,3,0,0,0,1,3,0,2,1,1,0,3,2,2,2,3,3,3,1,3,3,0,0,1,2,1,1,3,2,0,2,1,1,0,1,1,0,2,1,1,1,2,2,1,2,0,3,1,0,1,0};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		questionTextView = findViewById(R.id.questionTextView);
		answerRadioGroup = findViewById(R.id.answerRadioGroup);
		nextButton = findViewById(R.id.nextButton);
		resultTextView = findViewById(R.id.resultTextView);
		scores = findViewById(R.id.text_view_score);
		textViewCountDOwn = findViewById(R.id.text_view_countdown);
		//btn_prev = findViewById(R.id.prev);
		//chkAnswer = findViewById(R.id.checkBox);

		updateQuestion(currentQuestionIndex);

		/*if (chkAnswer.isChecked()){

		}*/

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();
				if (selectedRadioButtonId != -1) {
					int selectedAnswerIndex = getSelectedAnswerIndex(selectedRadioButtonId);
					if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
						Toast.makeText(quiz.this, "Correct!", Toast.LENGTH_SHORT).show();
						//showResults();
						totalCorrect++;
						scores.setText("Score: " + totalCorrect);

						timeLeftInMillis = COUNTDOWN_IN_MILLIS;
						startCountDown();
					} else {
						Toast.makeText(quiz.this, "Incorrect. Try again.", Toast.LENGTH_SHORT).show();

					}
					currentQuestionIndex++;
					if (currentQuestionIndex < questions.length) {
						updateQuestion(currentQuestionIndex);
					} else {
						showResult();
					}
				} else {
					Toast.makeText(quiz.this, "Please select an answer.", Toast.LENGTH_SHORT).show();
				}
			}
		});

		/*btn_prev.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


			}
		});*/




	}

	private void startCountDown(){
		countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
			@Override
			public void onTick(long l) {
				timeLeftInMillis = l;
				updateCountDownText();
			}

			@Override
			public void onFinish() {
				timeLeftInMillis = 0;
				updateCountDownText();
				//checkAnswer();
			}
		}.start();
	}

	private void checkAnswer(){
		//answered = true;

		RadioButton rbselected = findViewById(answerRadioGroup.getCheckedRadioButtonId());
		int answerNr = answerRadioGroup.indexOfChild(rbselected) + 1;


	}

	private void updateCountDownText() {
		int minutes = (int) (timeLeftInMillis /1000) /60;
		int seconds = (int) (timeLeftInMillis) /1000 % 60;

		String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
		textViewCountDOwn.setText(timeFormatted);

		if(timeLeftInMillis <10000){
			textViewCountDOwn.setTextColor(Color.RED);
		}
		else {
			textViewCountDOwn.setTextColor(textColorDefaultCd);
		}

	}
	private void updateQuestion(int questionIndex) {
		questionTextView.setText(questions[questionIndex]);
		answerRadioGroup.removeAllViews();
		for (String answer : answers[questionIndex]) {
			RadioButton radioButton = new RadioButton(this);
			radioButton.setText(answer);
			answerRadioGroup.addView(radioButton);
		}
		answerRadioGroup.clearCheck();
	}
	private int getSelectedAnswerIndex(int selectedRadioButtonId) {
		int radioButtonIndex = answerRadioGroup.indexOfChild(findViewById(selectedRadioButtonId));
		return radioButtonIndex;
	}

	@SuppressLint("SetTextI18n")
	private void showResult() {
		questionTextView.setVisibility(View.GONE);
		answerRadioGroup.setVisibility(View.GONE);
		nextButton.setVisibility(View.GONE);
		resultTextView.setVisibility(View.VISIBLE);

		int correctCount = 0;
		for (int i = 0; i < correctAnswers.length; i++) {
			if (correctAnswers[i] == answers[i].length - 1) {
				correctCount++;
			}
		}
		resultTextView.setText("You answered " + correctCount + " out of " + questions.length + " questions correctly!");
	}
	private void showResults() {

		int selectedAnswerIndex = answerRadioGroup.indexOfChild(findViewById(answerRadioGroup.getCheckedRadioButtonId()));
		if (selectedAnswerIndex == correctAnswers[currentQuestion]) {
			totalCorrect++;
			scores.setText("Score: " + totalCorrect);
		}


	}
}