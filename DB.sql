CREATE DATABASE StoreManagement

GO

USE StoreManagement

CREATE TABLE [dbo].[tblUser](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[fullname] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[role] [varchar](10) NULL,
	PRIMARY KEY(username)
);

INSERT INTO tblUser (username, password, fullname, email, role) VALUES 
('nhannq', '1', 'Nguyen Quoc Nhan', 'nhannq@gmail.com', 'admin');

CREATE TABLE [dbo].[TeddyBear](
	[bearID] [varchar](50) NOT NULL,
	[bearName] [nvarchar](50) NOT NULL,
	[bearImg] [varchar](300) NOT NULL,
	[description] [nvarchar](200) NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	PRIMARY KEY(bearID)
);

INSERT INTO [dbo].[TeddyBear] ([bearID], [bearName], [bearImg], [description], [price], [quantity]) VALUES
(?, ?, ?, ?, ?, ?)

CREATE TABLE [dbo].[tblCart](
	[username] [varchar](50) NOT NULL,
	[bearID] [varchar](50) NOT NULL,
	[bearName] [nvarchar](50) NOT NULL,
	[bearImg] [varchar](300) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tblCart]  WITH CHECK ADD  CONSTRAINT [FK_tblCart_tblUser] FOREIGN KEY([username])
REFERENCES [dbo].[tblUser] ([username])
GO

ALTER TABLE [dbo].[tblCart] CHECK CONSTRAINT [FK_tblCart_tblUser]
GO

ALTER TABLE [dbo].[tblCart]  WITH CHECK ADD  CONSTRAINT [FK_tblCart_TeddyBear] FOREIGN KEY([bearID])
REFERENCES [dbo].[TeddyBear] ([bearID])
GO

ALTER TABLE [dbo].[tblCart] CHECK CONSTRAINT [FK_tblCart_TeddyBear]
GO

INSERT INTO [dbo].[tblCart]([username], [bearID], [bearName], [bearImg], [description], [price], [quantity])
VALUES (?, ?, ?, ?, ?, ?, ?)