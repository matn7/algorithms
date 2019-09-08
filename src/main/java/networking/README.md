# TCP UDP

## IP Connectionless

```
PC1     ----> Internet ----> www
1.1.1.1                      2.2.2.2
```

- Every packet is treated individually and separately
- no guarantee packets arrived
- need to ensure reordering of packets

## OSI MODEL

```
 Application
+------------+
 Presentation
+------------+
 Session
+------------+
 Transport         *TCP / UDP
+------------+
 Network            IP address
+------------+
 Data Link          MAC address
+------------+
 Physical           Ethernrt / RJ-45
+------------+
```

- Session Multiplexing
    - single host with single IP address is able to commuicate with multiple server
    - connection must first established between server and receiver

- Segmentation
    - MTU depends on physical medium
    - MTU of fast ethernet is 1500 bytes
    - TCP support 65495 bytes
    - Maximum segment size (MSS) is the largest amount of data
    - MSS should be set small enough
    - TCP support MSS and Path MTU descovery
        - sender and receiver can automatically determine maximum transmission

- Flow Control
    - to avoid sending data too quickly
    - if sender send data faster than receiver can handle receiver drop data and require retransmission
        - TCP have sliding window to control flow of data
        - UDP does not implement flow control

- Connection Oriented
    - TCP is Connection Oriented
    - UDP is Connectionless
    - Once transmission is complete session is terminated

- Reliability
    - every segment transmitted is acknowledge
    - UDP does not implement reliability


### UDP (User Datagram Protocol)

- UDP is connection less
- does not guarantee delivery
- unreliability

***

- Transport Layer Protocol
- Access to layer 3 without the overhead of reliability mechanisms
- Connectionless protocol
- provides limited error delivery
- provides best effort delivery
- has no data recovery features

#### UDP Header

```
+--------------------+-------------------------+
| 16 bit source port | 16 bit destination port |
+--------------------+-------------------------+
| 16 bit UDP length  | 16 bit UDP checksum     |
+--------------------+-------------------------+
|                   Data                       |
+----------------------------------------------+
```
- **minimum 8 bytes**
- **maximum 65,535 bytes**

***

### TCP (Transmission Control Protocol)

- provide delivery acknowledgement and reliability
- Connection Oriented

***

- Transport Layer Protocol
- Access to the network layer for applications
- Connection oriented
- Full duplex mode operation - both host can transmit and receive
- Error checking
- Sequencing of data packets
- Acknowledgement of receipt
- Data recovery features

#### TCP Header

```
+--------------------+-------------------------+
| 16 bit source port | 16 bit destination port |
+--------------------+-------------------------+
| 32 bit sequence number                       |
+----------------------------------------------+
| 32 bit acknowledgement number                |
+---------------+----------+-+-----------------+
| Header length | Reserved |*|   Window Size   |
+---------------+----------+-+-----------------+
| 16 bit TCP checksum    16 bit urgent pointer |
+----------------------------------------------+
|                   Options                    |
+----------------------------------------------+
|                   Data                       |
+----------------------------------------------+
* CWR, ECE, URG, ACK, PSH, RST, SYN, FIN
```
- If **SYN** is set, actual sequence number plus 1
- If **SYN** is not set, sequence number is the accumulated sequence number

- If **ACK** is set, ack number value is equal to next sequence number that
receiver is expecting to receive

- **Header Length**:
    - Minimum size is 5 words   Min size of header is 20 bits
    - Maximum size is 15 words  Max size of header is 60 bits

- Reserved is set to **0** (reserved for future used)

- Congestion Window Reduced (CWR) flag
- Echo Congestion Notification Echo flag (ECE)
- Urgent flag indicate segment is urgent (URG)
- Acknowledgement (ACK) flag is used for acknowledgement of data
- Push (PSH)
- Reset (RST) reset connection (connection is down)
- Synchronize (SYN)
- Finish (FIN) no more data from sender

- Wndow size
    - Window size is 16 bit
    - Specify the size of the received window
    - The number of bits receiver is currently willing to receive

#### Applications

- File transfer:
    - FTP
    - TFTP
    - NFS
- Email
    - SMTP
- Remote login
    - Telnet
    - SSH
- Network Mgmt
    - SNMP
- Name Mgmt
    - DNS


***

### Socket

- Combination of:
    - IP address of host
    - port number used
    - transport protocol used

### TCP / UDP comparision

|| Reliable | Best Effort / Unreliable |
|---|---|---|
| Connection type | Connection Oriented | Connectionless |
| Protocol | TCP | UDP |
| Sequencing | Yes | No |
| Application | HTTP, E-mail, FTP | Voice Streaming, Video Streaming |


### How layers connect together

```
 Application
+------------+
 Presentation
+------------+
 Session
+------------+
 Transport
+------------+
 Network
+------------+
 Data Link
+------------+
 Physical
+------------+
```

- Data Link :arrow_right: Number (Type number)
    - allow to differentiate between multiple layer 3 protocol
    - Data Link - need to know which layer 3 protocol to send traffic and the type
    of number used
- Network :arrow_right: Transport (Protocol number)
    - TCP, UDP
- Transport :arrow_right: Application (Port number)

## Port Number

```
PC1                       Server

[SA] 10.1.1.1:60000       [DA] 10.1.2.1:80
----------------------------------------->

[SA] - source address
[DA] - destination address
```

- Apache
    - listen to traffic on port 80
- Transport layer (TCP) - send traffic to port 80
- Application layer - process the data received

```
PC1                       Server

[SA] 10.1.1.1:60000       [DA] 10.1.2.1:80
<-----------------------------------------
```

- Well known ports - <= 1023
- Registered port - 1024 to 49151
- Dynamically assigned ports - 49152 to 65535

| Application | Port number | Transport layer |
|---|---|---|
| HTTP | 80 | TCP |
| FTP | 21 | TCP |
| FTP Data | 20 | TCP |
| Telnet | 23 | TCP |
| DNS | 53 | TCP / UDP |
| TFTP | 69 | UDP |
| SNMP | 161 | UDP |

- iana port numbers

- used UDP on port number 53 to serve request
- TCP is used when response data exceeds to 512 bytes
    - Zone transfers are used for replication of databases

### Ephemeral Port Numbers

- Short lived port used for client side of connection
- temporary and only last for the duration of the session
- IANA suggest 49151 to 65535
- BSD uses ports 1024 through 4999
- linux used ports 32768 to 61000
- windows through server 2003 use 1025 to 5000
- vista / windows 7 use IANA range
- free BSD uses IANA range since release 4.6

## Establishing a Connection

```
{HOST A} --[Router]--[ Internet TCP/IP ]--[Router]-- {HOST B}
<----------------------------------------------------------->
```

- users of TCP must establish a connection oriented session with a peer system

### Three Way Handshake

**Step 1**

```
{HOST A} --[Router]--[ Internet TCP/IP ]--[Router]-- {HOST B}
------------------------------------------------------------>
Send SYN
    SEQ = 100   CTL = SYN
- specify the number of port sender wants to connect
```

**Step 2**

```
{HOST A} --[Router]--[ Internet TCP/IP ]--[Router]-- {HOST B}
<------------------------------------------------------------
                                                    Received SYN
                                                    Send SYN, ACK
                                                        CTL = SYN, ACK  SEQ = 300
                                                        ACK = 101
                                                    - Ack flag indicates the next portion of data
                                                    host expect to receive
```

**Step 3**

```
{HOST A} --[Router]--[ Internet TCP/IP ]--[Router]-- {HOST B}
------------------------------------------------------------>
SYN received & Session established
    CTL = ACK       ACK = 301       SEQ = 101
- Syn flag is unset, confirm that three way handshake has completed successfully
```

```
STEP 1
    Send SYN
    SEQ = 100   CTL = SYN

STEP 2
    SYN received
    Send SYN, ACK
    CTL = SYN, ACK  SEQ = 300   ACK = 101
    SYN & ACK is set to 1

STEP 3
    SYN received & Session established
        CTL = ACK   ACK = 301   SEQ = 101
    - Syn flag is unset, confirm that three way handshake has completed successfully
```

### TCP Seq & ACK

- Window Size is 1
    - maximum amount of data that receiver can receive

### Flow Control

- prevents the issue of a sender overflowing the buffers of a receiver

- receive buffer full
    - not ready by setting window size to 0
- Receive buffer ready
    - ready GO

## TCP Acknowledgement

- Window size = 1
    - number of data segments the sender is allowed to send
- sender cannot transmit data
- TCP allow greater window size

### Flow Control - Fixed Window Size

- Fixed Window Size 3
- Weighted Random Early Detection (WERD)
    - improve efficiency of TCP transmission
    - global synchronization









