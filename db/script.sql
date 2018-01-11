USE [master]
GO
/****** Object:  Database [shop_online]    Script Date: 1/11/2018 12:42:25 PM ******/
CREATE DATABASE [shop_online]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'shop_online', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\shop_online.ndf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'shop_online_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\shop_online_log.ldf' , SIZE = 1536KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [shop_online] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [shop_online].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [shop_online] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [shop_online] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [shop_online] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [shop_online] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [shop_online] SET ARITHABORT OFF 
GO
ALTER DATABASE [shop_online] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [shop_online] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [shop_online] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [shop_online] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [shop_online] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [shop_online] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [shop_online] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [shop_online] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [shop_online] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [shop_online] SET  ENABLE_BROKER 
GO
ALTER DATABASE [shop_online] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [shop_online] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [shop_online] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [shop_online] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [shop_online] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [shop_online] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [shop_online] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [shop_online] SET RECOVERY FULL 
GO
ALTER DATABASE [shop_online] SET  MULTI_USER 
GO
ALTER DATABASE [shop_online] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [shop_online] SET DB_CHAINING OFF 
GO
ALTER DATABASE [shop_online] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [shop_online] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [shop_online] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'shop_online', N'ON'
GO
USE [shop_online]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account] [nvarchar](50) NOT NULL,
	[password] [nvarchar](255) NULL,
	[email] [nvarchar](255) NOT NULL,
	[phone] [nvarchar](20) NULL,
	[birthday] [datetime] NULL,
	[address] [nvarchar](100) NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[active_status] [tinyint] NOT NULL,
	[status] [tinyint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[admin_role]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin_role](
	[admin_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[category]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name_category] [nvarchar](255) NOT NULL,
	[description] [text] NULL,
	[parent_id] [int] NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[coupon]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[coupon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NOT NULL,
	[value] [float] NOT NULL,
	[status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[guarantee]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[guarantee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[serial] [nvarchar](100) NOT NULL,
	[guarantee_from] [datetime] NULL,
	[guarantee_to] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[history_action]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[history_action](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[admin_id] [int] NULL,
	[client_info] [nvarchar](255) NULL,
	[access_type] [nvarchar](10) NULL,
	[execute_date] [datetime] NULL,
	[description] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[news]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[description] [nvarchar](255) NULL,
	[image_link] [nvarchar](255) NULL,
	[image_list] [nvarchar](255) NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[order]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[qty] [int] NOT NULL,
	[amount] [float] NOT NULL,
	[data] [nvarchar](255) NULL,
	[status] [tinyint] NOT NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[product_id] [int] NOT NULL,
	[transaction_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[persistent_logins]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persistent_logins](
	[account] [nvarchar](255) NULL,
	[series] [nvarchar](255) NULL,
	[token] [nvarchar](255) NULL,
	[last_used] [datetime] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[product]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_name] [nvarchar](255) NOT NULL,
	[price] [nvarchar](255) NULL,
	[discount] [nvarchar](53) NULL,
	[category_id] [int] NULL,
	[image_link] [nvarchar](255) NULL,
	[image_list] [nvarchar](255) NULL,
	[count_view] [float] NULL CONSTRAINT [DF__product__count_v__14270015]  DEFAULT ((0)),
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[detail] [nvarchar](255) NULL,
	[status] [tinyint] NOT NULL,
	[code] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[province]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[province](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[province_name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](255) NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[code] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[role]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NOT NULL,
	[type] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[user_id] [int] NOT NULL,
	[full_name] [nvarchar](50) NOT NULL,
	[user_email] [nvarchar](255) NOT NULL,
	[user_phone] [nvarchar](20) NOT NULL,
	[amount] [float] NOT NULL,
	[payment] [nvarchar](255) NULL,
	[payment_info] [nvarchar](255) NULL,
	[message] [nvarchar](255) NULL,
	[security] [nvarchar](50) NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK__transact__3213E83F546CB8DF] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 1/11/2018 12:42:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[phone] [nvarchar](20) NULL,
	[birthday] [datetime] NULL,
	[address] [nvarchar](255) NULL,
	[admin_create] [int] NULL,
	[admin_update] [int] NULL,
	[create_date] [datetime] NULL,
	[update_date] [datetime] NULL,
	[active_status] [tinyint] NOT NULL,
	[status] [tinyint] NOT NULL,
	[numTransaction] [int] NULL,
	[facebookId] [nvarchar](50) NULL,
	[facebooklink] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[admin_role]  WITH CHECK ADD FOREIGN KEY([admin_id])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[admin_role]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD FOREIGN KEY([parent_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[history_action]  WITH CHECK ADD FOREIGN KEY([admin_id])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD  CONSTRAINT [FK_news_admin] FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[news] CHECK CONSTRAINT [FK_news_admin]
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([transaction_id])
REFERENCES [dbo].[transactions] ([id])
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD FOREIGN KEY([admin_create])
REFERENCES [dbo].[admin] ([id])
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD FOREIGN KEY([admin_update])
REFERENCES [dbo].[admin] ([id])
GO
USE [master]
GO
ALTER DATABASE [shop_online] SET  READ_WRITE 
GO
